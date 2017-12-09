package lunch_together.purkynova.com.lunchtogetherclient;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

import lunch_together.purkynova.com.lunchtogetherclient.helper.CustomListAdapter;
import lunch_together.purkynova.com.lunchtogetherclient.model.CreateEvent;
import lunch_together.purkynova.com.lunchtogetherclient.model.Data;

import lunch_together.purkynova.com.lunchtogetherclient.model.GetRestaurants;
import lunch_together.purkynova.com.lunchtogetherclient.model.Model;

public class EventListActivity extends ListActivity implements View.OnClickListener {

    private Button createEvent;

    private ListView listView;
    private EditText date;
    private EditText time;
    private Model model;
    private int UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        try
        {
            new GetRestaurants().execute("").get();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        initParams();
        initUI();
    }

    private void initParams() {
        this.model = new Model();
        this.listView = getListView();

        this.createEvent = this.findViewById(R.id.create_event);

        Model.data.userID = this.getIntent().getExtras().getInt("id");
        model.initializeData(String.valueOf(Model.data.userID));
    }

    private void initUI() {
        listView.setOnItemClickListener(new OnItemClick());
        createEvent.setOnClickListener(this);

        CustomListAdapter eventAdapter = new CustomListAdapter(
                this,
                R.layout.activity_list_row,
                Model.data.events
        );
        setListAdapter(eventAdapter);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(model == null)
            new Model().initializeData(String.valueOf(Data.userID));
    }

    class OnItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(getApplicationContext(), EventActivity.class);
            intent.putExtra("EventID", Model.data.events.get(i).id);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.empty);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_event:
                showAddEvent();
        }
    }

    public void showDatePicker(final View view)
    {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth)
            {
                String month = String.valueOf(monthOfYear);
                String day = String.valueOf(dayOfMonth);

                if (month.length() == 1) month = "0" + month;
                if (day.length() == 1) day = "0" + day;

                ((EditText)(view)).setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
            }
        }, calendar.get(Calendar.YEAR) , calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public void showTimePicker(final View view)
    {
        Calendar calendar = Calendar.getInstance();

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1)
            {
                String hour = String.valueOf(i);
                String minutes = String.valueOf(i1);
                if (hour.length() == 1) hour = "0" + hour;
                if (minutes.length() == 1) minutes = "0" + minutes;

                ((EditText)view).setText(hour + ":" + minutes);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        dialog.show();
    }

    private void showAddEvent()
    {
        final View dialogView = getLayoutInflater().inflate(R.layout.dialog_event_list_add_event, null);

        date = (EditText) dialogView.findViewById(R.id.event_add_date);
        time = (EditText) dialogView.findViewById(R.id.event_add_time);
        TextView headerCreateTV = (TextView) dialogView.findViewById(R.id.headerCreateTV);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        headerCreateTV.setTypeface(font);

        ArrayList<String> restaurantsName = new ArrayList<>();
        for (int i = 0; i < Data.restaurants.size(); i++)
        {
            restaurantsName.add(Data.restaurants.get(i).name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, restaurantsName);
        AutoCompleteTextView restaurantsACTV = (AutoCompleteTextView)dialogView.findViewById(R.id.restaurantsACTV);
        restaurantsACTV.setAdapter(adapter);

        date.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if(b == true)
                    showDatePicker(view);
            }
        });

        time.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if(b == true)
                    showTimePicker(view);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setNegativeButton("Zrušit", null)
                .setPositiveButton("Vytvořit", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText title = (EditText) dialogView.findViewById(R.id.event_add_title);
                        EditText note = (EditText) dialogView.findViewById(R.id.event_add_note);
                        EditText tags = (EditText) dialogView.findViewById(R.id.event_add_tags);

                        if (title.length() == 0 || date.length() == 0 || time.length() == 0 || note.length() == 0) {
                            new Toast(getApplication())
                                    .makeText(getApplication(), "Některé povinné políčko je prázdné", Toast.LENGTH_LONG)
                                    .show();
                            return;
                        }
                        try
                        {
                            new CreateEvent().execute(String.valueOf(Data.userID), tags.getText().toString(),
                                    date.getText().toString() + " " + time.getText().toString(), title.getText().toString(), note.getText().toString()).get();
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                        // Kód, pomocí kterého se získané informace počlou serveru pod tuto řádku.
                    }
                });

        builder.show();
    }
}

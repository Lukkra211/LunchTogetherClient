package lunch_together.purkynova.com.lunchtogetherclient;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import lunch_together.purkynova.com.lunchtogetherclient.helper.CustomListAdapter;
import lunch_together.purkynova.com.lunchtogetherclient.model.Model;

public class EventListActivity extends ListActivity implements View.OnClickListener {

    private Button createEvent;

    private ListView listView;
    private Model model;
    private int UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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

    private void showAddEvent() {
        final View dialogView = getLayoutInflater().inflate(R.layout.dialog_event_list_add_event, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setNegativeButton("Zrušit", null)
                .setPositiveButton("Vytvořit", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText title = (EditText) dialogView.findViewById(R.id.event_add_title);
                        EditText note = (EditText) dialogView.findViewById(R.id.event_add_note);
                        EditText tags = (EditText) dialogView.findViewById(R.id.event_add_tags);
                        EditText date = (EditText) dialogView.findViewById(R.id.event_add_date);
                        EditText time = (EditText) dialogView.findViewById(R.id.event_add_time);

                        if (title.length() == 0 || date.length() == 0 || time.length() == 0 || note.length() == 0) {
                            new Toast(getApplication())
                                    .makeText(getApplication(), "Některé povinné políčko je prázdné", Toast.LENGTH_LONG)
                                    .show();
                            return;
                        }
                        // Kód, pomocí kterého se získané informace počlou serveru pod tuto řádku.
                    }
                });

        builder.show();
    }
}

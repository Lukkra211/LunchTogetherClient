package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import lunch_together.purkynova.com.lunchtogetherclient.helper.CustomListAdapter;
import lunch_together.purkynova.com.lunchtogetherclient.model.Data;
import lunch_together.purkynova.com.lunchtogetherclient.model.JoinEvent;
import lunch_together.purkynova.com.lunchtogetherclient.model.LeaveEvent;
import lunch_together.purkynova.com.lunchtogetherclient.model.Model;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

public class EventActivity extends AppCompatActivity
{

    AlertDialog.Builder builder;
    private int eventId;
    private ListView attendersLV;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.w("AAA", "called");
        setContentView(R.layout.activity_event);
        Intent in = getIntent();
        eventId = in.getExtras().getInt("EventID");

        TextView eventTitleTV = (TextView) findViewById(R.id.titleEventTV);
        TextView restaurantTV = (TextView) findViewById(R.id.restaurantTV);
        TextView placeTV = (TextView) findViewById(R.id.placeTV);
        TextView ratingsTV = (TextView) findViewById(R.id.ratingsTV);

        eventTitleTV.setText(Data.events.get(eventId - 1).title);

        attendersLV = findViewById(R.id.attendersLV);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < Data.events.get(eventId - 1).users.size(); i++)
        {
            users.add(Data.events.get(eventId - 1).users.get(i).fullname);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);

        attendersLV.setAdapter(adapter);
        builder = new AlertDialog.Builder(this);
        attendersLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView titleEventTV = findViewById(R.id.titleEventTV);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        titleEventTV.setTypeface(font);
        restaurantTV.setTypeface(font);
        placeTV.setTypeface(font);
        ratingsTV.setTypeface(font);

        if (eventId - 1 == Data.activeEvent)
        {
            findViewById(R.id.attendRL).setVisibility(View.GONE);
            findViewById(R.id.leaveRL).setVisibility(View.VISIBLE);
        } else
        {
            findViewById(R.id.attendRL).setVisibility(View.VISIBLE);
            findViewById(R.id.leaveRL).setVisibility(View.GONE);
        }
    }

    public void attend(View view) throws Exception
    {
        Data.activeEvent = eventId;
        new JoinEvent().execute(String.valueOf(Data.userID), String.valueOf(eventId)).get();
        findViewById(R.id.attendRL).setVisibility(View.GONE);
        findViewById(R.id.leaveRL).setVisibility(View.VISIBLE);

        adapter.add(Data.users.get(Data.userID-1).fullname);
    }

    public void leave(View view) throws Exception
    {
        Data.activeEvent = -1;
        new LeaveEvent().execute(String.valueOf(Data.userID)).get();
        findViewById(R.id.attendRL).setVisibility(View.VISIBLE);
        findViewById(R.id.leaveRL).setVisibility(View.GONE);
        adapter.remove(Data.users.get(Data.userID-1).fullname);
    }
}

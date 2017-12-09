package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.Locale;

import lunch_together.purkynova.com.lunchtogetherclient.model.Data;
import lunch_together.purkynova.com.lunchtogetherclient.model.Model;
import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;

public class EventActivity extends AppCompatActivity
{

    AlertDialog.Builder builder;
    int EventId;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent in = getIntent();
        EventId = in.getExtras().getInt("EventID");

        ListView attendersLV = findViewById(R.id.attendersLV);
        final String[] attenders = new String[]{"Jan Novak","Petr Horak", "Jana fsadfaskj", "fjsdhfkj sdkjf"};
        attendersLV.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,attenders));
        builder = new AlertDialog.Builder(this);
        attendersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                builder.setMessage("Jméno: " + attenders[(int)l] +"\nEmail: " + attenders[(int)l]);
              //  builder.setMessage("Email: " + attenders[(int)l]);
                builder.create().show();
            }
        });

        TextView titleEventTV = findViewById(R.id.titleEventTV);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        titleEventTV.setTypeface(font);
        if(EventId == Data.activeEvent)
        {
            ImageView lea = (ImageView) findViewById(R.id.ignoreIV);
            lea.setVisibility(View.VISIBLE);
            TextView igntw = (TextView) findViewById(R.id.ignoreTW);
            igntw.setVisibility(View.VISIBLE);
            TextView atttw = (TextView) findViewById(R.id.attendTW);
            atttw.setVisibility(View.GONE);
            ImageView att = (ImageView) findViewById(R.id.attendIV);
            att.setVisibility(View.GONE);
        }else
        {
            TextView igntw = (TextView) findViewById(R.id.ignoreTW);
            igntw.setVisibility(View.GONE);
            TextView atttw = (TextView) findViewById(R.id.attendTW);
            atttw.setVisibility(View.VISIBLE);
            ImageView att = (ImageView) findViewById(R.id.attendIV);
            att.setVisibility(View.VISIBLE);
            ImageView lea = (ImageView) findViewById(R.id.ignoreIV);
            lea.setVisibility(View.GONE);
        }

        findViewById(R.id.geoMaps).setOnClickListener(new StartMaps());

    }

    public void onClickAttend(View view) {
        if(Data.activeEvent == -1)
        {
            Data.activeEvent = EventId;
        }
    }

    public void onClickLeave(View view)
    {
        Data.activeEvent = -1;
    }

    private class StartMaps implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.w("AAA", "2");
            float x = 0;
            float y = 0;

            for (Event event: Model.data.events) {
                if (event.id == Model.data.activeEvent) {
                    x = event.restaurant.x;
                    y = event.restaurant.y;
                }
            }

            String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f", x, y, x, y);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }
    }
}

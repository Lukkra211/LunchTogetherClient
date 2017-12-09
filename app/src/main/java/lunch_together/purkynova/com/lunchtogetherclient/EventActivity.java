package lunch_together.purkynova.com.lunchtogetherclient;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import lunch_together.purkynova.com.lunchtogetherclient.model.Model;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

public class EventActivity extends AppCompatActivity
{

    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView titleEventTV = findViewById(R.id.titleEventTV);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        titleEventTV.setTypeface(font);
    }

}

package lunch_together.purkynova.com.lunchtogetherclient;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

public class EventActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ListView attendersLV = findViewById(R.id.attendersLV);
        String[] attenders = new String[]{"Jan Novak","Petr Horak", "Jana fsadfaskj", "fjsdhfkj sdkjf"};
        attendersLV.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,attenders));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView titleEventTV = findViewById(R.id.titleEventTV);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        titleEventTV.setTypeface(font);
    }
}

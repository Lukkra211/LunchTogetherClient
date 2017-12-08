package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

    }
    public void launchMaps(int x,int y)
    {
        Uri gmmIntentUri = Uri.parse("geo:"+x+","+y+"?q="+x+","+y+"");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
    public double getDistanceOfTwoPoints(double x1,double y1,double x2,double y2)
    {
        double distace;
        double dx;
        double dy;
        final double convert = 110.574f;
        if( x1 > x2)
        {
            dx = x1-x2;
        }else
        {
            dx = x2-x1;
        }

        if( y1 > y2)
        {
            dy = y1-y2;
        }else
        {
            dy = y2-y1;
        }
        return Math.sqrt(Math.pow(dy * convert,2) + Math.pow(dx * convert,2));
    }
}

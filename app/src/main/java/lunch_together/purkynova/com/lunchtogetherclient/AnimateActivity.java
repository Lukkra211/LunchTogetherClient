package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnimateActivity extends AppCompatActivity {

    Intent loginIntent;
    private Animation fadeIn = new AlphaAnimation(0,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        ((TextView)findViewById(R.id.animateActivity_logo)).setTypeface(font);
        loginIntent = new Intent(this,LoginActivity.class);

        setAnimation();

        new Handler().postDelayed(timeH, 3000);
    }

    private void setAnimation()
    {
        this.fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(3000/2);
        findViewById(R.id.animateActivity_logo).setAnimation(fadeIn);
        findViewById(R.id.animateActivity_thanks).setAnimation(fadeIn);
    }
    private Runnable timeH = new Runnable() {

        @Override
        public void run() {
            startActivity(loginIntent);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }
    };
}

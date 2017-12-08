package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {

    }

    public void onClickRegister_activityLogin(View view) {
        finish();
        Intent registerIntent = new Intent(this,registerActivity.class);
        startActivity(registerIntent); //starting registerActivity

    }
}

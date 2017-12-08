package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Vojtěch Kudláček
 */
public class loginActivity extends AppCompatActivity {
    private EditText nickEditText;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nickEditText = (EditText) findViewById(R.id.loginActivity_editTextnickName);
        passwordEditText = (EditText) findViewById(R.id.loginActivity_editTextPassword);
    }

    public void onClickLogin(View view) {
        int userID = -1;
        String nick = nickEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(!(nick.equals("") || password.equals("")))
        {
            //userID = loginFunction(name,password);
            if (userID > -1)
            {
                Intent listIntent = new Intent(this,MainActivity.class); //Edit to listActivity
                listIntent.putExtra("",userID);
                startActivity(listIntent);
            }else
            {
                Toast.makeText(this,"Heslo nebo email nebyli zadány správně",Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this,"Všechna pole musí být vyplněna",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickRegister_activityLogin(View view) {
        Intent registerIntent = new Intent(this,registerActivity.class);
        startActivity(registerIntent); //starting registerActivity

    }
}

package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import lunch_together.purkynova.com.lunchtogetherclient.model.Model;

/**
 * @author Vojtěch Kudláček
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditText = (EditText) findViewById(R.id.registerActivity_editTextName);
        emailEditText = (EditText) findViewById(R.id.registerActivity_editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.registerActivity_editTextPassword);
        passwordConfirmEditText = (EditText) findViewById(R.id.registerActivity_editTextPasswordConfirm);
    }

    public void onClickRegister_activityRegister(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String passwordConfirm = passwordConfirmEditText.getText().toString();
        String register = "";
        Model commModel = new Model();

        if(isNetworkAvailable()){
            if(password.equals(passwordConfirm) )
            {
                if (!(name.equals("") || email.equals("") || password.equals("")))
                {
                    register = commModel.register(name,email,password);
                    if(register.equals(""))
                    {
                        Toast.makeText(this,"Registrace proběhla úspěšně !",Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(this,LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(this, register, Toast.LENGTH_LONG).show();
                    }
                }else
                {
                 Toast.makeText(this,"Všechna pole musí být vyplněna !",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this,"Hesla se neshodují !",Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this,"Přístup k internetu není k dispozici !",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public void onClickBack_register(View view) {
        finish();
    }

    boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}

package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
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
        Boolean register = false;

        if(password.equals(passwordConfirm) )
        {
            if (!(name.equals("") || email.equals("") || password.equals("")))
            {
                //register = registerFunction(name,email,password);
                if(register)
                {
                    finish();
                    Intent loginIntent = new Intent(this,loginActivity.class);
                    startActivity(loginIntent);
                }
                else
                {
                    Toast.makeText(this, "Registrace byla neúspěšná", Toast.LENGTH_SHORT).show();
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
    }
}

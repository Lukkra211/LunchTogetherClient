package lunch_together.purkynova.com.lunchtogetherclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }
}

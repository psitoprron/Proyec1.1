package imec.proyec1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.unet);
        password = (EditText)findViewById(R.id.upet);

        Button login = (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passValidation()){
                    checkCredencials();
                };
            }

            private boolean checkCredencials() {
                boolean rigthCredential = true;
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                if (usernameText.equalsIgnoreCase("Hector")) {
                    if (passwordText.equalsIgnoreCase("hola")) {
                        //Todo chido
                        Toast.makeText(getApplicationContext(), "Credenciales Correctas", Toast.LENGTH_LONG).show();
                    } else {
                        username.setError("Password incorrecto");
                        rigthCredential = false;

                    }
                } else {
                    username.setError("Ususario incorrecto");
                    rigthCredential = false;
                }
                return rigthCredential;
            }
        });
        Log.d("MainActivity","Estoy en onCreate");
    }

    private boolean passValidation() {
        boolean passValidation = true;
        username.setError(null);
        password .setError(null);
        String usernameText = username.getText().toString();
        if (usernameText.length() == 0 ){  //Verificamos si el campo esta vacio
            username.setError("Este campo es obligatorio");
            passValidation = false;
        }
        String paswordText = password.getText().toString();
        if(paswordText.length() == 0){
            password.setError("Este tambien XD");
            passValidation = false;
        }
        return passValidation;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","Estoy en onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","Estoy en onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","Estoy en onDestroy");
    }
}

package com.phamminhtri.lab2androidnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtName;
    private Button btnLogin;
    String username, name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtName = (EditText) findViewById(R.id.edt_name);
        btnLogin = (Button) findViewById(R.id.btn_login);

        username = edtUsername.getText().toString();
        name = edtName.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Log.d("test1","username"+ username);
                HttpPostTask httpPostTask = new HttpPostTask(username, password, name);
                httpPostTask.execute("http://dotplays.com/android/login.php");
                break;
        }
    }
}

package com.example.raj.rpsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btn_register;
    EditText r_username, r_email, r_phone, r_password;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        r_username = (EditText) findViewById(R.id.r_username);
        r_email = (EditText) findViewById(R.id.r_email);
        r_password = (EditText) findViewById(R.id.r_pass);
        r_phone = (EditText) findViewById(R.id.r_phone);

        databaseHelper = new DatabaseHelper(this);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = r_username.getText().toString();
                String email = r_email.getText().toString();
                String phone = r_phone.getText().toString();
                String pass = r_password.getText().toString();

                if(username.equals("") || email.equals("") || pass.equals("") || phone.equals(""))
                {
                    Toast.makeText(Register.this,"Enter all field",Toast.LENGTH_LONG).show();
                }
                else
                {
                    databaseHelper.insert(username,email,phone,pass);
                    startActivity(new Intent(Register.this,Login.class));
                }
            }
        });
    }
}

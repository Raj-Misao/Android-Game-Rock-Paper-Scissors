package com.example.raj.rpsgame;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    TextView reg_link;
    EditText u_email, u_pass;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        u_email = (EditText) findViewById(R.id.u_email);
        u_pass = (EditText) findViewById(R.id.u_pass);

        reg_link = (TextView) findViewById(R.id.reg_link);

        btn_login = (Button) findViewById(R.id.btn_login);

        databaseHelper  = new DatabaseHelper(this);
        btn_login.setOnClickListener(this);
        reg_link.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_login:
                String email = u_email.getText().toString();
                String pass = u_pass.getText().toString();
                if(email.equals("") || pass.equals(""))
                {
                    Toast.makeText(this,"All field required",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Cursor crsr = databaseHelper.getData(email,pass);
                    if(crsr == null)
                    {
                        Toast.makeText(this,"No user found",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        String name = crsr.getString(crsr.getColumnIndexOrThrow("Name"));
                        Bundle bundle = new Bundle();
                        bundle.putString("Name",name);
                        Intent intent = new Intent(this,MainActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }
                break;

            case R.id.reg_link:
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                break;
        }
    }
}

package com.caly.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView log;
    Button login;
    EditText users,password;
    database sql;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log=findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        login=findViewById(R.id.login);
        users=findViewById(R.id.userw);
        password=findViewById(R.id.passw);
        sql=new database(this);

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=users.getText().toString();
                String pas=password.getText().toString();
                if (e.equals("") ||pas.equals("")) {
                    Toast.makeText(login.this, "Please All Fill In The Box", Toast.LENGTH_SHORT).show();
                }else {
                    boolean check=sql.checkemailpassword(e,pas);
                    if (check==true){
                        Toast.makeText(login.this, "Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(login.this,MainActivity3.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(login.this, "Failed...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
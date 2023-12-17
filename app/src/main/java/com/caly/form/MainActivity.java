package com.caly.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    EditText name,email,password;
    database sql;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
        signup=findViewById(R.id.signup);
        name=findViewById(R.id.name);
       email=findViewById(R.id.mail);
        password=findViewById(R.id.password);
        sql=new database(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=name.getText().toString();
                String m=email.getText().toString();
                String pass=password.getText().toString();

                if (t.equals("")||m.equals("")||pass.equals("")) {
                    Toast.makeText(MainActivity.this, "All Fill In The Box", Toast.LENGTH_SHORT).show();
                }else {
                    boolean chekuser=sql.checkusername(t);
                    if (chekuser==false) {
                        boolean insert=sql.insertdata(t,m,pass);
                        if (insert==true) {
                            Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Please Signin..", Toast.LENGTH_SHORT).show();
                    }
                }

                }
        });

    }
}
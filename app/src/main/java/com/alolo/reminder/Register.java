package com.alolo.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alolo.reminder.model.database.Database;
import com.alolo.reminder.model.database.Users;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Database obj1 = new Database(this);
        EditText r1 = findViewById(R.id.registName);
        EditText r2= findViewById(R.id.password2);
        findViewById(R.id.register2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj1.Insert_User(r1.getText().toString(),r2.getText().toString());
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);

            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
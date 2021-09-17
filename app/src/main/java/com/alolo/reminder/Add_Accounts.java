package com.alolo.reminder;

import static com.alolo.reminder.MainActivity.flag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.alolo.reminder.model.Accounts_List;

import com.alolo.reminder.model.database.Database;

public class Add_Accounts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accounts);
        Database obj = new Database(this);
        EditText r3 = findViewById(R.id.username2);
        EditText r4= findViewById(R.id.password3);
        findViewById(R.id.signin3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj.Insert_Account(r3.getText().toString(),r4.getText().toString(),flag);
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();

            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_Accounts.this,MainActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.signin6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_Accounts.this, Accounts_List.class);
                startActivity(i);

            }
        });
    }
}
package com.alolo.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alolo.reminder.model.database.Database;
import com.alolo.reminder.model.database.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public static int flag;
    public int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Database obj3 = new Database(this);
        EditText r3 = findViewById(R.id.username);
        EditText r4= findViewById(R.id.password);

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });
        findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Users> arr = obj3.Get_Users();


                for(int i1=0;i1<arr.size();i1++)
                {
                    if(arr.get(i1).getU_Name().equals(r3.getText().toString()) && arr.get(i1).getU_pass().equals(r4.getText().toString()))
                    {
                        flag = arr.get(i1).getU_idd();
                        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,Control.class);
                        startActivity(i);
                        f=1;
                    }

                }
                if(f==0)
                Toast.makeText(getApplicationContext(),"user or password wrong",Toast.LENGTH_SHORT).show();
                f=0;
            }
        });

    }
}
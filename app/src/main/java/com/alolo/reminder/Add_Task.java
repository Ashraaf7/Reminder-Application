package com.alolo.reminder;

import static com.alolo.reminder.MainActivity.flag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.alolo.reminder.model.Tasks_List;
import com.alolo.reminder.model.database.Database;

public class Add_Task extends AppCompatActivity {
    public String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        CalendarView calendarView = findViewById(R.id.calendarView);
        Database obj5 = new Database(this);
        EditText u = findViewById(R.id.username3);
       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date= i+ "/" + i1 + "/" + i2 ;

           }
       });
        findViewById(R.id.signin4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_Task.this, Tasks_List.class);
                startActivity(i);

            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_Task.this,MainActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.signin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj5.Insert_Task(u.getText().toString(),date,flag);
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
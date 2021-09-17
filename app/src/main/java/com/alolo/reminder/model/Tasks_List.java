package com.alolo.reminder.model;

import static com.alolo.reminder.MainActivity.flag;
import static com.alolo.reminder.R.layout.accounts_list;
import static com.alolo.reminder.R.layout.activity_tasks_list;
import static com.alolo.reminder.R.layout.tasks_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alolo.reminder.MainActivity;
import com.alolo.reminder.R;
import com.alolo.reminder.model.database.Accounts;
import com.alolo.reminder.model.database.Database;
import com.alolo.reminder.model.database.Tasks;

import java.util.ArrayList;

public class Tasks_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tasks_list);
        Database obj7 = new Database(this);
        ArrayList<Tasks> a2=obj7.Get_Tasks(flag);
        ListView list1 = findViewById(R.id.list_view1);
        MyCustom_Adabter1 adabter1=new MyCustom_Adabter1(a2);
        list1.setAdapter(adabter1);
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Tasks_List.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
    class MyCustom_Adabter1 extends BaseAdapter
    {
        ArrayList<Tasks> task=new ArrayList<Tasks>();
        MyCustom_Adabter1(ArrayList<Tasks> task)
        {
            this.task=task;
        }

        @Override
        public int getCount() {
            return task.size();
        }

        @Override
        public Object getItem(int i) {
            return task.get(i).getT_Name();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater=getLayoutInflater();
            View view1=layoutInflater.inflate(tasks_list,null);
            TextView t_name=(TextView) view1.findViewById(R.id.task_name);
            TextView dead=(TextView) view1.findViewById(R.id.deadline);
            t_name.setText(task.get(i).getT_Name());
            dead.setText(task.get(i).getDead());

            return view1;
        }
    }

}
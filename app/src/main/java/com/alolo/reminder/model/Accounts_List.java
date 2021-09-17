package com.alolo.reminder.model;

import static com.alolo.reminder.MainActivity.flag;
import static com.alolo.reminder.R.layout.accounts_list;
import static com.alolo.reminder.R.layout.activity_accounts_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alolo.reminder.Control;
import com.alolo.reminder.MainActivity;
import com.alolo.reminder.R;
import com.alolo.reminder.model.database.Accounts;
import com.alolo.reminder.model.database.Database;

import java.util.ArrayList;

public class Accounts_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_accounts_list);
        Database obj6 = new Database(this);
        ArrayList<Accounts> a1=obj6.Get_Accounts(flag);
        ListView list = findViewById(R.id.list_view2);
        MyCustom_Adapter adapter2=new MyCustom_Adapter(a1);
        list.setAdapter(adapter2);
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Accounts_List.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    class MyCustom_Adapter extends BaseAdapter
    {
        ArrayList<Accounts> acc=new ArrayList<Accounts>();
        MyCustom_Adapter(ArrayList<Accounts> acc)
        {
            this.acc=acc;
        }

        @Override
        public int getCount() {
            return acc.size();
        }

        @Override
        public Object getItem(int i) {
            return acc.get(i).getA_Name();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater=getLayoutInflater();
            View view2=layoutInflater.inflate(accounts_list,null);
            TextView a_name=(TextView) view2.findViewById(R.id.account_name);
            TextView pas=(TextView) view2.findViewById(R.id.pass);
            a_name.setText(acc.get(i).getA_Name());
            pas.setText(acc.get(i).getA_pass());

            return view2;
        }
    }

}
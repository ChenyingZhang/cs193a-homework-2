package com.example.chenyingzhang.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView to_do_list = (ListView) findViewById(R.id.to_do_list);
        to_do_list.setOnItemLongClickListener(this);

    }

    ArrayList<String> list = new ArrayList<String>();

    public void addItem(View view) {
        EditText newItem = (EditText) findViewById(R.id.newItem);
        String item = newItem.getText().toString();
        list.add(item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );
        ListView to_do_list = (ListView) findViewById(R.id.to_do_list);
        to_do_list.setAdapter(adapter);
        newItem.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        ListView to_do_list = (ListView) findViewById(R.id.to_do_list);
        list.remove(position);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );
        to_do_list.setAdapter(adapter);
        return false;
    }
}

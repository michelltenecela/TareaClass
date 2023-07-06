package com.example.tareaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listaview extends AppCompatActivity
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaview);

        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        //adap
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,datos);

        ListView lstListar = (ListView)findViewById(R.id.lstListar);
        lstListar.setAdapter(adaptador2);
        lstListar.setOnItemClickListener(new iListaAlumnos(this.getApplicationContext()));
    }

}
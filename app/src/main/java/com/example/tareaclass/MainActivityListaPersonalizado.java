package com.example.tareaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tareaclass.Adaptadores.AdaptadorNoticias;
import com.example.tareaclass.Modelos.Noticias;

public class MainActivityListaPersonalizado extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    public Noticias[] noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_personalizado);


        noticias =
                new Noticias[]{
                        new Noticias("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticias("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticias("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticias("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")};

        AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this,
                noticias);

        ListView lstOpciones = (ListView)findViewById(R.id.lstMostrarLista);

        View header =
                getLayoutInflater().inflate(
                        R.layout.lyheader
                        , null);

        lstOpciones.addHeaderView(header);

        lstOpciones.setAdapter(adaptadornoticias);
        lstOpciones.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivityListaPersonalizado.this, MainActivityVistaNoticia.class);
        Bundle b = new Bundle();
        Noticias noticia = (Noticias)adapterView.getItemAtPosition(i);
        b.putString("Titulo",noticia.getTitulo());
        b.putString("SubTitulo",noticia.getSubtitulo());
        intent.putExtras(b);
        startActivity(intent);
    }
}
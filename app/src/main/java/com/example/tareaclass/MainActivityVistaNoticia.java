package com.example.tareaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityVistaNoticia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vista_noticia);
        Bundle b = new Bundle();
        b= this.getIntent().getExtras();

        TextView txtTitulo = (TextView)findViewById(R.id.txtTitulo);
        TextView txtSubtitulo = (TextView)findViewById(R.id.txtSubtitulo);

        txtTitulo.setText(b.getString("Titulo"));
        txtSubtitulo.setText(b.getString("SubTitulo"));
    }
}
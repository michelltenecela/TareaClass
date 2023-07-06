package com.example.tareaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tareaclass.Adaptadores.AdaptadorRevistas;
import com.example.tareaclass.Adaptadores.AdaptadorUsuario;
import com.example.tareaclass.Modelos.Revistas;
import com.example.tareaclass.Modelos.Usuario;
import com.example.tareaclass.WebService.Asynchtask;
import com.example.tareaclass.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityVistaUsuario extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vista_usuario);

        lstOpciones= (ListView)findViewById(R.id.lstListaUsuario);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivityVistaUsuario.this, MainActivityVistaUsuario.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray JSONlistaUsuarios= new JSONArray(result);
        ArrayList lstUsuarios = Revistas.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorRevistas adapatorUsuario = new AdaptadorRevistas(this, lstUsuarios);
        lstOpciones.setAdapter(adapatorUsuario);
    }
}
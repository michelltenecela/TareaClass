package com.example.tareaclass.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ediciones {

    private String volume;

    private String number;

    private String date_published;

    private String title;


    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ediciones(JSONObject a) throws JSONException {
        volume = a.getString("volume").toString();
        number = a.getString("number").toString();
        date_published = a.getString("date_published").toString() ;
        title = a.getString("title").toString() ;
    }
    public static ArrayList<Ediciones> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Ediciones> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Ediciones(datos.getJSONObject(i)));
        }
        return usuarios;
    }

}

package com.example.tareaclass.Modelos;

public class Noticias {
    private String titulo;
    private String subtitulo;

    public Noticias(String tit, String subtitulo) {
        this.titulo = tit;
        this.subtitulo = subtitulo;
    }

    public String getTitulo(){ return titulo; }
    public String getSubtitulo() { return subtitulo; }

    @Override
    public String toString(){
        return titulo +" "+ subtitulo;
    }
}

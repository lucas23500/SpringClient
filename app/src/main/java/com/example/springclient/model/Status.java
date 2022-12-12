package com.example.springclient.model;


public class Status {


    private Long id;

    private String titulo;

    private String descricao;

    public Status(String titulo) {
        this.titulo = titulo;
    }

    public Status(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Status() {
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

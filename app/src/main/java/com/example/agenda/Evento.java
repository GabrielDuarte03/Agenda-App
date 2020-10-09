package com.example.agenda;

public class Evento {

    private long idEvento;
    private String nome;
    private String data;
    private String hora;
    private String observacao;

    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString(){
        String todosEventos = String.format("ID: %d\nNome do evento: %s\nData do evento: %s\nHora do evento: %s\nObservação sobre o evento: %s\n",idEvento,nome,data,hora,observacao);
        return todosEventos;
    }

}

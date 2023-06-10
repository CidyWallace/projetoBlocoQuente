package org.example.classes;

public class Pedido {
    private String nome;
    private int id;
    private boolean status;

    private Cardapio cardapio;

    public Pedido(String nome, int id, boolean status) {
        this.nome = nome;
        this.id = id;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPreco(String nome){
        cardapio = new Cardapio();
        return cardapio.pegaPreco(nome);
    }
}

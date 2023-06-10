package org.example.classes;

public class Pedido implements Comparable<Pedido> {
    private String nome;
    private double preco;
    private int id;
    private boolean status;
    private static int num = 0;

    public Pedido(String nome, Cardapio cardapio) {
        this.nome = nome;
        this.setId(gerador_numero());
        this.status = false;
        this.setPreco(cardapio);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Cardapio cardapio) {
        this.preco = cardapio.pegaPreco(getNome());
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

    private static int gerador_numero(){
        return num++;
    }

    @Override
    public int compareTo(Pedido o) {
        return nome.compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}

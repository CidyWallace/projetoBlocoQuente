package org.example.classes;

public class Pedido implements Comparable<Pedido> {
    private String nome;
    private double preco;
    private int id;
    private boolean status;
    private static int num = 1;

    Cardapio Repcardapio;

    public Pedido(int numero, Cardapio cardapio) {
        this.nome = cardapio.pegaNome(numero);
        this.setId(gerador_numero());
        this.status = false;
        Repcardapio = cardapio;
        this.setPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco() {
        this.preco = Repcardapio.pegaPreco(getNome());
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

    private static int gerador_numero() {
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

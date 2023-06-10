package org.example.classes;

public class Mesa {
    private int numero;
    private boolean disponivel;

    public Mesa(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
    }

    private int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "numero=" + numero +
                ", disponivel=" + disponivel +
                '}';
    }
}

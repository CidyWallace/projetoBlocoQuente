package org.example.classes;

public class Funcionario {
    private String senha;

    public Funcionario() {
        this.senha = "123";
    }

    public boolean validaSenha(String nome){
        return senha.equals(nome);
    }
}

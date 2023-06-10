package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<String> listNome;
    private List<Double> listPreco;

    public Cardapio() {
        this.listNome = new ArrayList<>();
        this.listPreco = new ArrayList<>();
    }

    public double pegaPreco(String nome){
        for (int i = 0; i < listNome.size(); i++) {
            if(listNome.get(i).equals(nome)){
                return listPreco.get(i);
            }
        }
        return 0.0;
    }

    private void add_nomes(){
        if(listNome.equals(null)){

        }
    }

    private void add_precos(){
        if(listPreco.equals(null)){

        }
    }
}

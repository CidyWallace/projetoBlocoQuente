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
            listNome.add("Sanduíche Fumegante");
            listNome.add("Churrasco Ardente");
            listNome.add("Espetinho Infernal");
            listNome.add("Salada Vulcânica");
            listNome.add("Sobremesa Incendiária");
            listNome.add("Suco Tropical Explosivo");
            listNome.add("Suco Energia em Chamas");
            listNome.add("Suco Refrescante do Vulcão");
            listNome.add("Suco Frutas em Fogo");
        }
    }

    private void add_precos(){
        if(listPreco.equals(null)){
            listPreco.add(18.99);
            listPreco.add(32.99);
            listPreco.add(16.99);
            listPreco.add(12.99);
            listPreco.add(28.99);
            listPreco.add(9.99);
            listPreco.add(8.99);
            listPreco.add(7.99);
            listPreco.add(9.99);
            listPreco.add(8.99);
        }
    }
}

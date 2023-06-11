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
    public String pegaNome(int numero){
        return listNome.get(numero);
    }

    public void add_nomes(){
            listNome.add("Sanduíche Fumegante");
            listNome.add("Churrasco Ardente");
            listNome.add("Espetinho Infernal");
            listNome.add("Salada Vulcânica");
            listNome.add("Pizza em Chamas");
            listNome.add("Sobremesa Incendiária");
            listNome.add("Suco Tropical Explosivo");
            listNome.add("Suco Energia em Chamas");
            listNome.add("Suco Refrescante do Vulcão");
            listNome.add("Suco Frutas em Fogo");
    }

    public void add_precos(){
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
    public String todosOsItens(){
        String todos = "";
        for (int i = 0; i < listNome.size(); i++) {
            todos += i+".";
            todos += listNome.get(i) + ", ";
            todos += listPreco.get(i) + "R$";
            todos += "\n";
        }
        return todos;
    }
}

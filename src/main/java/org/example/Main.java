package org.example;

import org.example.classes.Cardapio;
import org.example.classes.Mesa;
import org.example.classes.Pedido;
import org.example.classes.PedidoRep;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        PedidoRep repositorio = new PedidoRep();

        for (int i = 0; i < 10; i++) {
            Mesa mesa = new Mesa(i, true);
            repositorio.addMesa(mesa);
        }

        System.out.println( repositorio.pegarMesa(1));

        cardapio.add_nomes();
        cardapio.add_precos();

        Pedido pedido= new Pedido("Sanduíche Fumegante", cardapio);
        Pedido pedido1= new Pedido("Pizza em Chamas", cardapio);
        Pedido pedido2= new Pedido("Suco Frutas em Fogo", cardapio);

        repositorio.addPedido(pedido);
        repositorio.addPedido(pedido1);
        repositorio.addPedido(pedido2);

        System.out.println(repositorio.pegaPedido(0));

        repositorio.mudarPedido(0, "Suco Frutas em Fogo");

        System.out.println(repositorio.pegaPedido(0));
        //repositorio.getRelatorios();
    }
}
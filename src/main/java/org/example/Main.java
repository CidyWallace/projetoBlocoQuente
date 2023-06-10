package org.example;

import org.example.classes.Cardapio;
import org.example.classes.Pedido;
import org.example.classes.PedidoRep;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        cardapio.add_nomes();
        cardapio.add_precos();
        PedidoRep pedidoRep = new PedidoRep();
        Pedido pedido= new Pedido("Sanduíche Fumegante", cardapio);
        Pedido pedido1= new Pedido("Pizza em Chamas", cardapio);
        Pedido pedido2= new Pedido("Suco Frutas em Fogo", cardapio);

        pedidoRep.addPedido(pedido);
        pedidoRep.addPedido(pedido1);
        pedidoRep.addPedido(pedido2);

        pedidoRep.getRelatorios();
    }
}
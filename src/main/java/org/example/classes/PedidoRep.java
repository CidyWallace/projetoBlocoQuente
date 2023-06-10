package org.example.classes;


import java.util.ArrayList;
import java.util.List;

public class PedidoRep {
    private List<Pedido> pedidoList;

    public PedidoRep(){
        pedidoList = new ArrayList<>();
    }
    public void addPedido(Pedido pedido){
        pedidoList.add(pedido);
    }
    public void removePedido(int numero){
        pedidoList.remove(numero);
    }
    public String pegaPedido(int numero){
        return pedidoList.get(numero).toString();
    }
    public void cancelaPedido(int numero){
        pedidoList.remove(numero);
    }
}

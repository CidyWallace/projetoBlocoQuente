package org.example.classes;


import java.util.ArrayList;
import java.util.List;

public class PedidoRep {
    private List<Pedido> pedidoList;
    private List<Mesa> mesaList = new ArrayList<>();

    public PedidoRep(){
        pedidoList = new ArrayList<>();
    }
    public void addPedido(Pedido pedido){
        pedidoList.add(pedido);
    }
    public String pegaPedido(int numero){
        return pedidoList.get(numero).toString();
    }
    public void cancelaPedido(int numero){
        pedidoList.remove(numero);
    }
    public void getRelatorios(){
        for (Pedido pedido : pedidoList) {
            System.out.println(pedido.toString());
        }
    }
}

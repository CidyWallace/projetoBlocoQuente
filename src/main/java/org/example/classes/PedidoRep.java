package org.example.classes;


import java.util.ArrayList;
import java.util.List;

public class PedidoRep {
    private List<Pedido> pedidoList;
    private List<Mesa> mesaList = new ArrayList<>();

    //pedido
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
        if(pedidoList.get(numero).isStatus() == false){
            pedidoList.remove(numero);
        }
    }
    public void mudarPedido(int num, String nome){
        if(pedidoList.get(num).isStatus() == false){
            pedidoList.get(num).setNome(nome);
            pedidoList.get(num).setPreco();
        }
    }
    public void pagarPedido(int num){
        if(pedidoList.get(num).isStatus() == false){
            pedidoList.get(num).setStatus(true);
        }
    }

    //Mesa
    public void addMesa(Mesa mesa){
        mesaList.add(mesa);
    }
    public Mesa pegarMesa(int numero){
        if(mesaList.get(numero) != null){
            return mesaList.get(numero);
        }
        return null;
    }

    public void getRelatorios(){
        for (Pedido pedido : pedidoList) {
            System.out.println(pedido.toString());
        }
    }
}

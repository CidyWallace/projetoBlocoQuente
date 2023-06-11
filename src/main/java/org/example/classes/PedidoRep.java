package org.example.classes;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoRep {
    private List<Pedido> pedidoList;
    private List<Mesa> mesaList;

    //pedido
    public PedidoRep() {
        pedidoList = new ArrayList<>();
        mesaList = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        pedidoList.add(pedido);
    }

    public String pegaPedido(int num) {
        return pedidoList.get(getIdPedido(num)).toString();
    }

    public void cancelaPedido(int num) {
        if (pedidoList.get(getIdPedido(num)).isStatus() == false) {
            pedidoList.remove(getIdPedido(num));
        }
    }

    public void mudarPedido(int num, String nome) {
        if (pedidoList.get(getIdPedido(num)).isStatus() == false) {
            pedidoList.get(getIdPedido(num)).setNome(nome);
            pedidoList.get(getIdPedido(num)).setPreco();
        }
    }

    public void pagarPedido(int num) {
        if (pedidoList.get(getIdPedido(num)).isStatus() == false) {
            pedidoList.get(getIdPedido(num)).setStatus(true);
        }
    }

    //Mesa
    public void addMesa(Mesa mesa) {
        mesaList.add(mesa);
    }

    public Mesa pegarMesa(int numero) {
        if (mesaList.get(numero) != null) {
            return mesaList.get(numero);
        }
        return null;
    }

    public String getRelatorios() {
        String tudo = "";

        for (int i = 0; i < pedidoList.size(); i++) {
            tudo += (i + 1) + ". ";
            tudo += pedidoList.get(i).toString();
            tudo += "\n";
        }
        return tudo;
    }

    public void SalvarRelaório(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Relatório.txt"))) {
            for (Pedido item: pedidoList) {
                bw.write(item.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ornanizarList(){
        Collections.sort(pedidoList);
    }

    private int getIdPedido(int num) {
        for (int i = 0; i < pedidoList.size(); i++) {
            if (pedidoList.get(i).getId() == num) {
                return i;
            }
        }
        return 0;
    }
}

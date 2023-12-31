package org.example.classes;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoRep {
    private List<Pedido> pedidoList;
    //pedido
    public PedidoRep() {
        pedidoList = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        pedidoList.add(pedido);
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

    public String getRelatorios() {
        String tudo = "";

        for (int i = 0; i < pedidoList.size(); i++) {
            tudo += (i + 1) + "º ";
            tudo += pedidoList.get(i).toString();
            tudo += "\n";
        }
        return tudo;
    }

    public void SalvarRelatório(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Relatório" + localDateTime.format(formatter) + ".txt"))) {
            for (Pedido item: pedidoList) {
                bw.write(item.toString());
                bw.newLine();
            }
            bw.write("Total arrecadado R$"+totalArrecadado()+"\nData:" + localDateTime.format(formatter));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void organizarList(){
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

    private float totalArrecadado(){
        double total = 0;
        for (int i = 0; i < pedidoList.size(); i++) {
            total += pedidoList.get(i).getPreco();
        }

        return (float) total;
    }
}

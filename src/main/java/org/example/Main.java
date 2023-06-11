package org.example;

import org.example.classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        cardapio.add_nomes();
        cardapio.add_precos();
        PedidoRep repositorio = new PedidoRep();
        Funcionario funcionario = new Funcionario();

        for (int i = 0; i < 10; i++) {
            Mesa mesa = new Mesa(i, true);
            repositorio.addMesa(mesa);
        }
        boolean sair = false;
        while (!sair){
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("\nBem vindo ao restaurante Bloco Quente");
            System.out.println("Digite oque desaja realizar");
            System.out.println("0.Cardapio\n1.Realizar pedido\n2.Menu para funcionarios");
            int opcao = in.nextInt();
            switch (opcao) {
                case (0) -> {
                    System.out.println(cardapio.todosOsItens());
                }
                case (1) -> {
                    System.out.println("Para realizar o pedido coloque o nome do item do menu");
                    in.nextLine();
                    String escolha = in.nextLine();
                    Pedido pedido = new Pedido(escolha, cardapio);
                    repositorio.addPedido(pedido);
                }
                case (2) -> {
                    System.out.println("Para acessar o menu do funcionario informe a senha:");
                    in.nextLine();
                    String senha = in.nextLine();
                    if(funcionario.validaSenha(senha)){
                        boolean sairMenuFuncionario = false;
                        while(!sairMenuFuncionario){
                        System.out.println("Menu do funcionario");
                        System.out.println("Digite oque deseja realizar:");
                        System.out.println("0. Alterar pedido\n1. Concluir pedido do cliente\n2. Gerar relatorio e salvar\n3. Sair do menu funcionario\n");
                        opcao = in.nextInt();
                        int escolha;
                        String escolha1;
                        switch (opcao){
                            case (0) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("Digite o numero do pedido que deseja alterar: \n");
                                escolha = in.nextInt();
                                System.out.println(cardapio.todosOsItens());
                                System.out.println("Digite para oque deseja alterar: \n");
                                in.nextLine();
                                escolha1 = in.nextLine();
                                repositorio.mudarPedido(escolha, escolha1);

                            }
                            case (1) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("\nDigite o numero do pedido que deseja concluir: \n");
                                escolha = in.nextInt(); in.nextLine();
                                repositorio.pagarPedido(escolha);

                            }
                            case (2) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("\nRepresentação do relatorio salvo");
                            }
                            case (3) -> {
                                sairMenuFuncionario = true;
                            }
                        }
                            }
                        }

                    }
                }
            }
    }}
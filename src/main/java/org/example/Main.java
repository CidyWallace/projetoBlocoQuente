package org.example;

import org.example.classes.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Cardapio cardapio = new Cardapio();
        cardapio.add_nomes();
        cardapio.add_precos();
        PedidoRep repositorio = new PedidoRep();
        Funcionario funcionario = new Funcionario();
        boolean sair = false;
        
        while (!sair) {
            Scanner in = new Scanner(System.in);
            System.out.println("Bem-vindo ao restaurante Bloco Quente!");
            System.out.println("Digite o número correspondente à ação desejada:\n");
            System.out.println("0. Cardápio\n1. Realizar pedido\n2. Menu para funcionários\n");
            int opcao;
            while (true) {
            try {
                opcao = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Use apenas os números indicados.");
                in.nextLine();
                }
            }
            int escolha;
            switch (opcao) {
                case (0) -> {
                    System.out.println("\n"+cardapio.todosOsItens());
                }
                case (1) -> {
                    System.out.println("\n"+cardapio.todosOsItens());
                    System.out.println("Para realizar o pedido, coloque o número do item.");
                    while (true) {
                    try {
                        escolha = in.nextInt();
                        System.out.println();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Use apenas os números indicados.");
                        in.nextLine();
                        }
                    }
                    Pedido pedido = new Pedido(escolha, cardapio);
                    repositorio.addPedido(pedido);
                }
                case (2) -> {
                    System.out.println("\nPara acessar o menu do funcionário, informe a senha:");
                    in.nextLine();
                    String senha = in.nextLine();
                    if(funcionario.validaSenha(senha)) {
                        boolean sairMenuFuncionario = false;
                        while(!sairMenuFuncionario){
                        System.out.println("\nMenu do funcionário");
                        System.out.println("Digite o que deseja realizar:\n");
                        System.out.println("0. Alterar pedido\n1. Concluir pedido do cliente\n2. Visualizar relatório\n3. Sair do menu funcionário\n4. Fechar sistema e salvar os relatórios\n5. Cancelar pedido");
                            while (true) {
                                try{
                                    opcao = in.nextInt();
                                    break;
                                } 
                                catch (InputMismatchException e){
                                    System.out.println("Use apenas os números indicados.");
                                    in.nextLine();
                                }
                            }
                        String escolha1;
                        switch (opcao) {
                            case (0) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("Digite o número do pedido que deseja alterar: \n");
                                while (true) {
                                try {
                                    escolha = in.nextInt(); break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Use apenas os números indicados.");
                                    in.nextLine();
                                    }
                                }
                                int aux = escolha; in.nextLine();
                                System.out.println(cardapio.todosOsItens());
                                System.out.println("Digite para oque deseja alterar: \n");
                                while (true) {
                                    try {
                                        escolha = in.nextInt(); break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Use apenas os números indicados.");
                                        in.nextLine();
                                    }
                                }
                                escolha1 = cardapio.pegaNome(escolha);
                                repositorio.mudarPedido(aux, escolha1);
                            }
                            case (1) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("\nDigite o número do pedido que deseja concluir: \n");
                                while (true) {
                                    try {
                                        escolha = in.nextInt(); break;
                                    } catch (InputMismatchException e){
                                        System.out.println("Use apenas os números indicados.");
                                        in.nextLine();
                                    }
                                }
                                repositorio.pagarPedido(escolha);
                            }
                            case (2) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("Representação do relatório");
                            }
                            case (3) -> {
                                sairMenuFuncionario = true;
                            }
                            case (4) -> {
                                repositorio.organizarList();
                                repositorio.SalvarRelatório();
                                sairMenuFuncionario = true; sair = true;
                            }
                            case(5) -> {
                                System.out.println(repositorio.getRelatorios());
                                System.out.println("\nInforme qual pedido deseja cancelar:\n");
                                while (true) {
                                    try {
                                        escolha = in.nextInt(); break;
                                    } catch (InputMismatchException e){
                                        System.out.println("Use apenas os números indicados.");
                                        in.nextLine();
                                    }
                                }
                                repositorio.cancelaPedido(escolha);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
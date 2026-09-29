package Tematica02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lanchonete {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int numero = 1;
        int opcao;

        do {
            System.out.println("\n1 - Adicionar pedido");
            System.out.println("2 - Processar pedido");
            System.out.println("3 - Exibir pedidos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Descrição do pedido: ");
                String descricao = scanner.nextLine();
                fila.add("Pedido " + numero + " - " + descricao);
                System.out.println("Pedido " + numero + " adicionado.");
                numero++;
            } else if (opcao == 2) {
                if (fila.isEmpty()) {
                    System.out.println("Não há pedidos na fila.");
                } else {
                    System.out.println("Processando: " + fila.remove());
                }
            } else if (opcao == 3) {
                if (fila.isEmpty()) {
                    System.out.println("A fila está vazia.");
                } else {
                    for (String pedido : fila) {
                        System.out.println(pedido);
                    }
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}

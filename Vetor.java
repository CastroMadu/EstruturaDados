import java.util.InputMismatchException;
import java.util.Scanner;

public class Vetor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== Tematica 01 ===");

        final int capacidade = 20; // capacidade maxima do vetor (limite fixo)
        String[] elemento = new String[capacidade];

        // Contador de quantas posicoes estao efetivamente preenchidas
        // (usado so para saber se o vetor esta cheio/vazio e para
        // estatisticas na impressao; NAO e mais usado para validar posicao).
        int quantidadeElementos = 0;

        int opcao = 0;

        while (opcao != 8) {
            try {
                System.out.println("1 - Inserir elementos em um vetor na proxima posição livre");
                System.out.println("2 - Inserir elementos em um vetor na posição que voce deseja");
                System.out.println("3 - Pesquisar um elemento no vetor pelo elemento informado");
                System.out.println("4 - Pesquisar um elemento no vetor pela posição do vetor");
                System.out.println("5 - Excluir um elemento do vetor pelo elemento informado");
                System.out.println("6 - Excluir um elemento do vetor pela posição informada");
                System.out.println("7 - Exibir o vetor");
                System.out.println("8 - Sair");

                System.out.println("Selecione uma opção: ");
                opcao = entrada.nextInt();

                switch (opcao) {

                    case 1: {
                        // Inserir na próxima posição LIVRE (primeiro slot == null)
                        if (quantidadeElementos == capacidade) {
                            System.out.println("O sistema não pode inserir mais elementos, vetor cheio.");
                            break;
                        }

                        int posicaoLivre = -1;
                        for (int i = 0; i < capacidade; i++) {
                            if (elemento[i] == null) {
                                posicaoLivre = i;
                                break;
                            }
                        }

                        System.out.println("Digite o elemento que deseja adicionar: ");
                        String resposta = entrada.next();

                        elemento[posicaoLivre] = resposta;
                        quantidadeElementos++;

                        System.out.println("Elemento inserido com sucesso na posição " + posicaoLivre + "!");
                        break;
                    }

                    case 2: {
                        // Inserir em uma posição ESPECÍFICA, validada pela
                        // CAPACIDADE do vetor (0 até capacidade - 1), e não
                        // pela quantidade de elementos já preenchidos.
                        System.out.println("Digite a posição que deseja inserir no vetor: 0 até " + (capacidade - 1));
                        int posicao = entrada.nextInt();

                        if (posicao < 0 || posicao >= capacidade) {
                            System.out.println("Posição inválida! Deve estar entre 0 e " + (capacidade - 1) + ".");
                            break;
                        }

                        boolean posicaoEstavaVazia = (elemento[posicao] == null);

                        System.out.println("Digite o elemento que deseja inserir:");
                        String resposta2 = entrada.next();

                        // Endereçamento direto: não há mais deslocamento (shift)
                        // de elementos, já que agora qualquer posição dentro da
                        // capacidade pode ser usada diretamente.
                        elemento[posicao] = resposta2;

                        if (posicaoEstavaVazia) {
                            quantidadeElementos++;
                        } else {
                            System.out.println("(A posição já estava ocupada; o valor anterior foi sobrescrito.)");
                        }

                        System.out.println("Elemento inserido com sucesso na posição " + posicao + ".");
                        break;
                    }

                    case 3: {
                        // Pesquisar por elemento: percorre TODA a capacidade,
                        // não apenas as posições preenchidas em sequência,
                        // já que agora o vetor pode ter "buracos" (null).
                        System.out.print("Digite a palavra que deseja pesquisar: ");
                        String pesquisaElemento = entrada.next();

                        boolean encontrado = false;

                        for (int i = 0; i < capacidade; i++) {
                            // .equals chamado a partir de "pesquisaElemento" (que
                            // nunca é null) evita NullPointerException quando
                            // elemento[i] estiver vazio.
                            if (pesquisaElemento.equals(elemento[i])) {
                                System.out.println("Palavra encontrada na posição " + i);
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Palavra não encontrada.");
                        }
                        break;
                    }

                    case 4: {
                        // Pesquisar por posição: validado pela CAPACIDADE.
                        System.out.println("Digite a posição que deseja consultar (0 até " + (capacidade - 1) + "): ");
                        int pesquisaPosicao = entrada.nextInt();

                        if (pesquisaPosicao < 0 || pesquisaPosicao >= capacidade) {
                            System.out.println("Posição inválida! Deve estar entre 0 e " + (capacidade - 1) + ".");
                        } else if (elemento[pesquisaPosicao] == null) {
                            System.out.println("A posição " + pesquisaPosicao + " está vazia.");
                        } else {
                            System.out.println("Elemento na posição " + pesquisaPosicao + ": " + elemento[pesquisaPosicao]);
                        }
                        break;
                    }

                    case 5: {
                        // Excluir pelo elemento informado: procura em toda a
                        // capacidade e apenas limpa a posição (null), sem
                        // deslocar os demais elementos.
                        System.out.println("Digite o nome do elemento que deseja excluir: ");
                        String nomeExclusao = entrada.next();

                        int excluir = -1;
                        for (int i = 0; i < capacidade; i++) {
                            if (nomeExclusao.equals(elemento[i])) {
                                excluir = i;
                                break;
                            }
                        }

                        if (excluir == -1) {
                            System.out.println("Elemento não encontrado.");
                        } else {
                            elemento[excluir] = null;
                            quantidadeElementos--;
                            System.out.println("Elemento excluído com sucesso da posição " + excluir + ".");
                        }
                        break;
                    }

                    case 6: {
                        // Excluir pela posição informada: validado pela CAPACIDADE.
                        System.out.print("Digite a posição que deseja excluir (0 até " + (capacidade - 1) + "): ");
                        int posicaoExclusao = entrada.nextInt();

                        if (posicaoExclusao < 0 || posicaoExclusao >= capacidade) {
                            System.out.println("Posição inválida.");
                        } else if (elemento[posicaoExclusao] == null) {
                            System.out.println("Essa posição já está vazia.");
                        } else {
                            elemento[posicaoExclusao] = null;
                            quantidadeElementos--;
                            System.out.println("Elemento excluído com sucesso.");
                        }
                        break;
                    }

                    case 7: {
                        // Exibe todas as posições de 0 até capacidade - 1,
                        // mostrando quais estão vazias.
                        System.out.println("--- Vetor (capacidade " + capacidade + ") ---");
                        for (int i = 0; i < capacidade; i++) {
                            String valor = (elemento[i] == null) ? "(vazio)" : elemento[i];
                            System.out.println("Posição " + i + ": " + valor);
                        }
                        System.out.println("Total de posições preenchidas: " + quantidadeElementos + "/" + capacidade);
                        break;
                    }

                    case 8:
                        System.out.println("Programa Encerrado");
                        break;

                    default:
                        System.out.println("Opção Inválida");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                entrada.nextLine(); // limpa o token inválido do buffer
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                entrada.nextLine();
            }

            System.out.println();
        }

        entrada.close();
    }
}
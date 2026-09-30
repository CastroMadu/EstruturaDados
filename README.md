# Temática 01 - Fila (Queue)

Uma **fila** é uma estrutura de dados linear em que os elementos são organizados na ordem de chegada, seguindo o princípio **FIFO (First In, First Out)** — o primeiro elemento a entrar é o primeiro a sair.

## Características
- Inserção sempre no **final** (rear).
- Remoção sempre no **início** (front).
- Não permite acesso direto a elementos do meio, só às extremidades.
- Operações principais: `enqueue` (inserir), `dequeue` (remover), `peek` (consultar o início), `isEmpty`, `isFull`.

## Tipos
- **Fila simples**: segue o FIFO de forma direta.
- **Fila circular**: reaproveita espaços liberados, otimizando memória em arrays de tamanho fixo.
- **Fila de prioridade**: elementos saem de acordo com a prioridade, não pela ordem de chegada.
- **Deque**: permite inserir e remover em ambas as extremidades.

## Exemplos práticos
- Fila de impressão.
- Atendimento por senha (bancos, call centers).
- Escalonamento de processos em sistemas operacionais.
- Filas de mensagens (Kafka, RabbitMQ).
- Buffer de streaming de vídeo/áudio.

# Temática 02 - diferenças entre Fila, Lista e Pilha 

## Estruturas de Dados: Fila, Lista e Pilha

As estruturas de dados servem para organizar as informações dentro de um programa, e escolher a estrutura certa ajuda o sistema a funcionar melhor. A lista, a fila e a pilha são estruturas lineares, ou seja, os elementos ficam um depois do outro. A diferença entre elas está na forma como os dados entram, saem e são acessados.

### Definição e características

**Lista:** é uma coleção ordenada de elementos em que é possível inserir, remover e acessar dados em qualquer posição. Ela pode ser feita com array ou com nós ligados por ponteiros (lista encadeada), e o tamanho pode crescer ou diminuir.

**Fila:** segue o princípio FIFO (*First In, First Out*), em que o primeiro a entrar é o primeiro a sair. Os elementos entram no final (*enqueue*) e saem pelo início (*dequeue*), como em uma fila de banco.

**Pilha:** segue o princípio LIFO (*Last In, First Out*), em que o último a entrar é o primeiro a sair. A inserção (*push*) e a remoção (*pop*) acontecem sempre no topo, como em uma pilha de pratos.

### Exemplos de uso

- **Lista:** lista de compras e cadastro de livros de uma biblioteca.
- **Fila:** fila de impressão, atendimento em caixa eletrônico e pedidos de uma lanchonete.
- **Pilha:** botão de desfazer e refazer em editores de texto e histórico de páginas de um navegador.

### Vantagens, desvantagens e complexidade

| Estrutura | Inserção | Remoção | Acesso |
|---|---|---|---|
| Lista (array) | O(1) no fim, O(n) no meio | O(1) no fim, O(n) no meio | O(1) por índice |
| Lista encadeada | O(1) no início, O(n) nas outras posições | O(1) no início, O(n) nas outras posições | O(n) |
| Fila | O(1) no final | O(1) no início | Só o primeiro elemento |
| Pilha | O(1) no topo | O(1) no topo | Só o elemento do topo |

A **lista** é a mais flexível, mas inserir ou remover no meio de um array exige deslocar elementos, e na lista encadeada é preciso percorrer os nós para chegar a uma posição. A **fila** é simples e mantém a ordem de chegada, com inserção e remoção rápidas, mas não permite acessar qualquer elemento diretamente. A **pilha** também tem operações rápidas e é boa para desfazer ações, mas só permite acesso ao topo.

Na prática, essa diferença de complexidade influencia a escolha da estrutura. Se o programa precisa consultar dados por posição com frequência, a lista em array é a melhor opção, pois o acesso é imediato, O(1). Se o programa faz muitas inserções e remoções no início, a lista encadeada é mais vantajosa, porque não precisa deslocar elementos, mas a busca fica mais lenta, O(n), já que é preciso percorrer os nós. Quando o sistema precisa atender na ordem de chegada, como nos pedidos de uma lanchonete, a fila resolve com inserção e remoção em O(1). E quando é preciso voltar atrás, como no desfazer de um editor de texto, a pilha resolve com push e pop em O(1). Em estruturas com muitos dados, essas diferenças fazem o programa ficar rápido ou lento.

### Conclusão

Lista, fila e pilha são estruturas lineares com regras diferentes: a lista permite trabalhar em qualquer posição, a fila segue a ordem de chegada (FIFO) e a pilha segue a ordem inversa (LIFO). Nenhuma é melhor que as outras em todos os casos, e a escolha depende do problema e das operações mais usadas.

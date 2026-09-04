# Fila (Queue)

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

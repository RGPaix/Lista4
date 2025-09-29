package Ex_06;

public class Lista {
    private No inicio;
    private No fim;
    private int tamanho;

    public void inserirNoFim(Integer dado) {
        No novo = new No(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public void inserirNoInicio(Integer dado) {
        No novo = new No(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    public void inserirOrdenado(Integer dado) {
        No novo = new No(dado);

        if (inicio == null) {
            inicio = fim = novo;
            tamanho++;
            return;
        }

        // Inserir no início (valor menor que o primeiro)
        if (dado <= inicio.dado) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
            tamanho++;
            return;
        }

        // Inserir no fim (valor maior que o último)
        if (dado >= fim.dado) {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
            tamanho++;
            return;
        }

        // Inserir no meio - encontrar posição correta
        No atual = inicio;
        while (atual != null && atual.dado < dado) {
            atual = atual.proximo;
        }

        // Inserir antes do nó atual
        novo.proximo = atual;
        novo.anterior = atual.anterior;
        atual.anterior.proximo = novo;
        atual.anterior = novo;
        tamanho++;
    }

    public boolean buscar(Integer dado) {
        No atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                return true;
            }
            // Otimização: se encontrou um valor maior, pode parar a busca
            // (assumindo que a lista está ordenada)
            if (atual.dado > dado) {
                return false;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void remover(Integer dado) {
        No atual = inicio;
        while (atual != null && !atual.dado.equals(dado)) {
            atual = atual.proximo;
        }
        if (atual == null) return;
        if (atual.anterior != null) {
            atual.anterior.proximo = atual.proximo;
        } else {
            inicio = atual.proximo;
        }
        if (atual.proximo != null) {
            atual.proximo.anterior = atual.anterior;
        } else {
            fim = atual.anterior;
        }
        tamanho--;
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }
}

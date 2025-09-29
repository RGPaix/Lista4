package Ex_04;

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

    public void removerPares() {
        No atual = inicio;
        while (atual != null) {
            // proteção contra NullPointerException (opcional)
            if (atual.dado != null && atual.dado % 2 == 0) {
                No prev = atual.anterior;
                No next = atual.proximo;

                if (prev != null) {
                    prev.proximo = next;
                } else {
                    inicio = next;
                }

                if (next != null) {
                    next.anterior = prev;
                } else {
                    fim = prev;
                }

                tamanho--;
                atual = next;
            } else {
                atual = atual.proximo;
            }
        }
    }
}

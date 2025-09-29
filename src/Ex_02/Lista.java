package Ex_02;

import Ex_01.No;

public class Lista<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public void inserirNoFim (T dado){
        No<T> novo = new No<>(dado);
        if (inicio == null){
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public void inserirNoInicio (T dado){
        No<T> novo = new No<>(dado);
        if (inicio == null){
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    public void remover (T dado){
        No<T> atual = inicio;
        while (atual != null && !atual.dado.equals(dado)){
            atual = atual.proximo;
        }
        if (atual == null) return;
        if (atual.anterior != null){
            atual.anterior.proximo = atual.proximo;
        } else {
            inicio = atual.proximo;
        }
        if (atual.proximo != null){
            atual.proximo.anterior = atual.anterior;
        } else {
            fim = atual.anterior;
        }
        tamanho--;
    }

    public void exibir(){
        No<T> atual = inicio;
        while (atual != null){
            System.out.println(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int contarOcorrencias(T valor) {
        int count = 0;
        No<T> atual = inicio;
        while (atual != null){
            if (atual.dado != null && atual.dado.equals(valor)) {
                count++;
            }
        atual = atual.proximo;
        }
        return count;
    }
}

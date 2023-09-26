/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author dados
 */
import java.util.Scanner;

class No {
int valor;
No direita;
No esquerda;
public No(int valor){
    this.valor = valor;
    this.direita = null;
    this.esquerda = null;
}
public int getValor(){return this.valor;}
public No getEsquerda(){return esquerda;}
public No getDireita(){return direita;}



}



public class ArvoreBinaria {
    No raiz;

    public void ArvoreBinaria() {
        this.raiz = null;
    }
    
    public void inserir(int valor){
        raiz = inserirRecursivo(raiz,valor);
    }
    public No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            No no = new No(valor);
            raiz = no;
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        }if (valor >= raiz.valor) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }

        return raiz;
    }

    void PreOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.valor + " ");
            PreOrdem(raiz.esquerda);
            PreOrdem(raiz.direita);
        }
    }

    void InOrdem(No raiz) {
        if (raiz != null) {
            InOrdem(raiz.esquerda);
            System.out.println(raiz.valor + " ");
            InOrdem(raiz.direita);
        }
    }

    void PosOrdem(No raiz) {
        if (raiz != null) {
            PosOrdem(raiz.esquerda);
            PosOrdem(raiz.direita);
            System.out.println(raiz.valor + " ");
        }
    }


    No removerMaior(No raiz) {
        if (raiz == null) {
        return null;
        }
        
        if (raiz.direita == null) {
            return raiz.esquerda;
        }
        raiz.direita = removerMaior(raiz.direita);
        return raiz;
    }

    

    No removerMenor(No raiz) {
        if (raiz == null) {
        return null;
        }
        
        if (raiz.esquerda == null) {
            return raiz.direita;
        }
        raiz.esquerda = removerMenor(raiz.esquerda);
        return raiz;
    }


    void removerN(No raiz, int N) {
        if (raiz == null) {
            System.out.println("Arvore Vazia");
            return;
        }

        if (N < raiz.valor) {
            removerN(raiz.esquerda, N);
        } else if (N > raiz.valor) {
            removerN(raiz.direita, N);
        } else if(N == raiz.valor){
            if(raiz.esquerda == null && raiz.direita == null){
            raiz = null;
            }
            if (raiz.esquerda != null){
                No noRemovido = removerMaior(raiz.esquerda);
                raiz.valor = noRemovido.valor;
            }
            

    }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("---------------------------------------------");
            System.out.println("Escolha como percorrer:");
            System.out.println("1 - Pre-ordem");
            System.out.println("2 - Inordem");
            System.out.println("3 - Pos-ordem");
            System.out.println("4 - Remover maior elemento");
            System.out.println("5 - Remover menor elemento");
            System.out.println("6 - Remover elemento N");
            System.out.println("7 - Inserir elemento");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    
                    System.out.println("modo Pre-ordem:");
                    arvore.PreOrdem(arvore.raiz );
                    break;
                case 2:
                    System.out.println("modo Inordem:");
                    arvore.InOrdem(arvore.raiz );
                    break;
                case 3:
                    System.out.println("modo Pos-ordem:");
                    arvore.PosOrdem(arvore.raiz );
                    break;
                case 4:
                    arvore.removerMaior(arvore.raiz);
                    System.out.println("Arvore apos a remocao:");
                    arvore.InOrdem(arvore.raiz);
                    break;
                case 5:
                    arvore.removerMenor(arvore.raiz);
                    System.out.println("Arvore apos a remocao:");
                    arvore.InOrdem(arvore.raiz);
                    break;
                case 6:
                    System.out.println("Digite N para ser removido:");
                    int valorRemover = scanner.nextInt();
                    arvore.removerN(arvore.raiz,valorRemover);
                    System.out.println("Arvore apos a remocao de N " + valorRemover + ":" );
                    arvore.InOrdem(arvore.raiz);
                    break;
                case 7:
                    System.out.println("Digite valor para ser Inserido:");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    System.out.println("Arvore apos a inserção de " + valorInserir + ":" );
                    arvore.InOrdem(arvore.raiz);
                    break;
                case 0:
                    System.out.println("Saindo." );
                    break;
                
            }
        } while (escolha != 0);

        scanner.close();
    }
}

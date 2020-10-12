package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Pedido
 */
public class Pedido {
    // ID numérico para identificação de um pedido
    private int numero;
    // Lista de itens de um pedido
    private List<Item> itens;

    /**
     * Método construtor da classe
     * @param numero Número do pedido
     */
    public Pedido (int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    /**
     * Método para retornar o número do pedido
     * @return Número de identificação do pedido
     */
    public int getNumero () {
        return this.numero;
    }

    /**
     * Método para adicionar um item em um pedido
     * @param item Item de um pedido
     */
    public void adicionaItem (Item item) {
        this.itens.add(item);
    }

    /**
     * Método para remover um item do pedido
     * @param posicao Posição do item no pedido
     */
    public void removeItem (int posicao) {
        this.itens.remove(posicao);
    }

    /**
     * Método para imprimir a lista de itens do pedido
     */
    public void imprime() {
        int numItem = 1;
        System.out.println ("Pedido Número: " + this.numero);
        for (Item item : itens) {
            System.out.print("Item #" + numItem + ":");
            System.out.println (item.getDescricao() + "\t R$ " + item.getPreco());
        }
        System.out.println();
    }

    /**
     * Método para retornar a lista de itens do pedido
     * @return Lista de itens
     */
    public List<Item> getItens() {
        return this.itens;
    }
}

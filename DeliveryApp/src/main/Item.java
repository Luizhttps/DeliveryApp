package main;

/**
 * Classe Item de um Pedido
 */
public class Item {
    // Descrição do item de um pedido
    private String descricao;
    // Preço do item de um pedido
    private double preco;

    /**
     * Método construtor do item de um pedido
     * @param descricao Descrição textual de um item
     * @param preco     Preço de um item 
     */
    public Item (String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Método para retornar a descrição textual do item
     * @return Descrição textual do item
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Método para atualizar a descrição textual de um item
     * @param descricao Descrição textual atualizada de um item
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método para retornar o preço de um item
     * @return Preço de um item
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Método para atualizar o preço de um item
     * @param preco Preço atualizado de um item
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}

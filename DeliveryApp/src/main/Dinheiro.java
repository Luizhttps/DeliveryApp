package main;

import javax.swing.JOptionPane;

/**
 * Classe para a implementação do tipo de pagamento Dinheiro
 */
public class Dinheiro implements IPagamentoImpl {
    
    private double valorDinheiro;
    private double troco;

    /**
     * Método construtor da classe
     * @param pedido Pedido realizado pelo cliente
     */
    public Dinheiro(Pedido pedido) {
        this.valorDinheiro = Double.MIN_VALUE;
        this.troco = Double.MIN_VALUE;
    }


    @Override
    public void leitura (Pedido pedido) {
        double totalPedido = 0;

        System.out.println ("Pedido No.: " + pedido.getNumero());
        for (Item item : pedido.getItens()) 
            totalPedido += item.getPreco();

        JOptionPane.showMessageDialog(null, "Valor do pedido: R$" + totalPedido);
        
        do {
            this.valorDinheiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Troco para: "));
        } while (this.valorDinheiro<totalPedido);
    }

    @Override
    public void processamento() {
        System.out.println ("Processando o pagamento...");
        System.out.println ("Valor pago pelo cliente: " + this.valorDinheiro);
    }

    @Override
    public void emissao(Pedido pedido) {
        double totalPedido = 0;

        System.out.println ("Pedido No.: " + pedido.getNumero());
        for (Item item : pedido.getItens()) 
            totalPedido += item.getPreco();

        this.troco=this.valorDinheiro-totalPedido;

        JOptionPane.showMessageDialog(null, "Valor total:  R$" + totalPedido + 
                                            "\nValor Pago:  R$" + this.valorDinheiro +
                                            "\nSeu troco:    R$" + this.troco);

        System.out.println ("Total.....: R$ " + totalPedido);
        System.out.println ("Valor pego pelo cliente: " + this.valorDinheiro);
        System.out.println ("Troco: " + this.troco);
    }
}

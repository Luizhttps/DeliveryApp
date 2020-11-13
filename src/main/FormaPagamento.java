package main;

import javax.swing.JOptionPane;

/**
 * Classe para a implementação da escolha do metodo de pagamento
 */
public class FormaPagamento {
    private Object[] opcaoPagamento = {"","Cartao", "Dinheiro", "Boleto"};

    /**
     * Método construtor da classe
     */
    public FormaPagamento(){}

    /**
     * Inicia o processamento do método de pagamento
     * @param pedido Pedido realizado pelo cliente
     */
    public void metodoPagamento(Pedido pedido){
        Object selectedValue = JOptionPane.showInputDialog(null,"Forma de Pagamento", "Input",
            JOptionPane.INFORMATION_MESSAGE, null, this.opcaoPagamento, opcaoPagamento[0]);

        if (selectedValue == "Cartao") {
            CartaoCredito cartaoCredito = new CartaoCredito();
            cartaoCredito.leitura(pedido);
            cartaoCredito.processamento();
            cartaoCredito.emissao(pedido);
        } else if (selectedValue == "Boleto") {
            Boleto boleto = new Boleto();
            boleto.leitura(pedido);
            boleto.processamento();
            boleto.emissao(pedido);
        } else if (selectedValue == "Dinheiro") {
            Dinheiro dinheiro = new Dinheiro(pedido);
            dinheiro.leitura(pedido);
            dinheiro.processamento();
            dinheiro.emissao(pedido);
        }
    }
}

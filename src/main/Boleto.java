package main;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe para a implementação do tipo de pagamento Boleto Bancário
 * @hidden https://gerencianet.com.br/blog/campos-dos-boletos-linha-digitavel/
 * @hidden https://facil123.com.br/blog/boleto-bancario-campos/
 */
public class Boleto implements IPagamentoImpl {

    private String bancoEmissor;
    private String beneficiario;
    private int numeroDocumento;
    private Date dataVencimento;
    private double valorBoleto;
    private String instrucoes;
    private String linhaDigitavel;
    private Boolean emitido;
    private double troco;

    /**
     * Método construtor da classe
     */
    public Boleto() {
        this.bancoEmissor = this.beneficiario = "";
        this.numeroDocumento = Integer.MIN_VALUE;
        this.dataVencimento = new Date();
        this.valorBoleto = Double.MIN_VALUE;
        this.instrucoes = this.linhaDigitavel = "";
        this.emitido = false;
        this.troco = Double.MIN_VALUE;
    }

    
    /** 
     * @param pedido Pedido realizado pelo cliente
     */
    @Override
    public void leitura(Pedido pedido) {
        do {
            this.bancoEmissor = JOptionPane.showInputDialog(null, "Banco Emissor");
        } while (this.bancoEmissor.equals(""));

        do {
            this.beneficiario = JOptionPane.showInputDialog(null, "Beneficiário");
        } while (this.beneficiario.equals(""));
        
        do {
            this.numeroDocumento = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do documento"));
        } while (this.numeroDocumento <= 0);

        double totalPedido = 0;

        System.out.println ("Pedido No.: " + pedido.getNumero());
        for (Item item : pedido.getItens()) 
            totalPedido += item.getPreco();
        JOptionPane.showMessageDialog(null, "Valor do pedido: R$" + totalPedido);
        
        do {
            this.valorBoleto = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor de pagamento:"));
        } while (this.valorBoleto<totalPedido);

        //this.valorBoleto = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor de pagamento"));
        this.instrucoes = JOptionPane.showInputDialog(null, "Instruções adicionais");
        this.linhaDigitavel = JOptionPane.showInputDialog(null, "Linha digitável do boleto");
    }

    @Override
    public void processamento() {
        if (this.emitido == false) {
            System.out.println ("Processando o pagamento do boleto");
            System.out.println ("Banco emissor......: " + this.bancoEmissor);
            System.out.println ("Beneficiário.......: " + this.beneficiario);
            System.out.println ("Número do documento: " + this.numeroDocumento);
            System.out.println ("Valor do documento.: " + this.valorBoleto);
            System.out.println ("Data de vencimento.: " + this.dataVencimento.toString());
            System.out.println ("Linha digitável....: " + this.linhaDigitavel);
            System.out.println ("Instruções.........: " + this.instrucoes);
            System.out.println ("Boleto bancário foi emitido com SUCESSO!");    
            this.emitido = true;
        } else {
            System.out.println ("Boleto já emitido!");
            System.out.println ("Linha digitável....: " + this.linhaDigitavel);
        }
    }

    
    /** 
     * @param pedido Pedido realizado pelo cliente
     */
    @Override
    public void emissao(Pedido pedido) {
        double totalPedido = 0;

        System.out.println ("Pedido No.: " + pedido.getNumero());
        for (Item item : pedido.getItens()) 
            totalPedido += item.getPreco();

        this.troco=this.valorBoleto-totalPedido;

        JOptionPane.showMessageDialog(null, "Valor total:  R$" + totalPedido + 
                                            "\nValor Pago:  R$" + this.valorBoleto +
                                            "\nSeu troco:    R$" + this.troco);

        System.out.println ("Total.....: R$ " + totalPedido);
        System.out.println ("Boleto bancário PAGO com SUCESSO!");
    }
    
}

package main;

/**
 * Interface para implementação de métodos de pagamento
 */
public interface IPagamentoImpl {

    /**
     * Efetua a leitura dos dados do método de pagamento
     * @param pedido Pedido realizado pelo cliente
     */
    public void leitura(Pedido pedido);

    /**
     * Efetua o processamento dos dados do método de pagamento
     */
    public void processamento();

    /**
     * Realiza a emissão do pagamento do pedido
     * @param pedido Pedido realizado pelo cliente
     */
    public void emissao(Pedido pedido);
}

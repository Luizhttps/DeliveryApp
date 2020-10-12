package main;

//import javax.swing.JOptionPane;

/**
 * Classe com o método principal para iniciar a aplicação
 */
public class App {
    
    /**
     * Método construtor para a App main
     * @param args parametro padrao main java
     */
    public static void main(String[] args) {

        Pedido pedido = new Pedido(1);

        Menu menu = new Menu();
        menu.menuPedidos(pedido);
        
        boolean confirm;

        do{
            menu.mostraPedido();
            confirm = menu.confirmaPedido();

            if (confirm == true){
                FormaPagamento pagamento = new FormaPagamento();
                pagamento.metodoPagamento(pedido);
            }else{
                menu.removerPedido(pedido);
            }
            pedido.imprime();
        }while(confirm == false);
    }
}

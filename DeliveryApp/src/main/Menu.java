package main;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface para implementação do Menu de pedidos
 */
public class Menu {
    private Object[] comida = {"", "Pizza", "Lanche", "Marmitex"}; //Vetor Object do cardapio Comida
    private Object[] bebida = {"", "Agua", "Coca-Cola", "Cerveja"}; //Vetor Object do cardapio Bebida
    private Object[] doce = {"", "Pudim", "Bolo", "Sorvete"}; // Vetor Object do cardapio Doce
    private double[] priceComida = {0.0, 25.0, 15.0, 13.0}; //Vetor double com preço da comida
    private double[] priceBebida = {0.0, 2.0, 3.0, 4.0}; //Vetor double com o preço da bebida
    private double[] priceDoce = {0.0, 5.0, 5.0, 3.0}; //vetor double com o preço do doce
    private double precoComida, precoBebida, precoDoce, precoTotal;
    private Object selectedComida, selectedBebida, selectedDoce;
    private String[] selectedItens;
    private double[] priceItens;
    private Object deleteItem;
    private int confirm;
    private int pos;
    private List<String> itens;//List string com o itens pedidos

    /**
     * Método construtor da classe Menu
     */
    public Menu(){
        this.precoComida = this.precoBebida = this.precoDoce = Double.MAX_VALUE;
        this.precoTotal = 0.0;
        this.selectedComida = this.selectedBebida = this.selectedDoce = "";
        this.deleteItem = "";
        this.confirm = 0;
        this.selectedItens = new String[3];
        this.priceItens = new double[3];
        this.pos = 0;
        this.itens = new ArrayList<>();
    }
    
    /**
     * Efetua a leitura do pedido
     * @param pedido Pedido realizado pelo cliente
     */
    public void menuPedidos(Pedido pedido){
        this.selectedComida = JOptionPane.showInputDialog(null,"Comida: ", "Cardapio",
            JOptionPane.INFORMATION_MESSAGE, null, this.comida, comida[0]);

        this.selectedBebida = JOptionPane.showInputDialog(null,"Bebida: ", "Cardapio",
            JOptionPane.INFORMATION_MESSAGE, null, this.bebida, bebida[0]);

        this.selectedDoce = JOptionPane.showInputDialog(null,"Doce: ", "Cardapio",
            JOptionPane.INFORMATION_MESSAGE, null, this.doce, doce[0]);

        
        for (int i=0; i<comida.length && i<bebida.length && i<doce.length; i++){
            if (this.selectedComida == comida[i])
                this.precoComida = priceComida[i];
            if (this.selectedBebida == bebida[i])
                this.precoBebida = priceBebida[i];
            if (this.selectedDoce == doce[i]) 
                this.precoDoce = priceDoce[i];
        }
        
        selectedItens[0]=selectedComida.toString();
        selectedItens[1]=selectedBebida.toString();
        selectedItens[2]=selectedDoce.toString();
        priceItens[0]=precoComida;
        priceItens[1]=precoBebida;
        priceItens[2]=precoDoce;

        for(int i=0; i<3; i++)
            this.precoTotal += this.priceItens[i];
        
        for(int i=0; i<3; i++)
            pedido.adicionaItem(new Item(selectedItens[i].toString(), priceItens[i]));
    }

    /**
     * Método para mostrar a lista de itens do pedido para o cliente
     */
    public void mostraPedido(){
        int cont=0;
        for(int i=0; i<3; i++){
            if(selectedItens[i] == "")
                cont++;
        }
        if(cont == 3){
            confirm = 1;
            JOptionPane.showMessageDialog(null, "Pedido sem Itens");
            System.exit(0);
        }
        else{
            Object msg="";
            if(selectedItens[0] != "")
                msg+= selectedItens[0]+" R$ "+ priceItens[0] +"\n";
            if(selectedItens[1] != "")
                msg+= selectedItens[1]+" R$ "+ priceItens[1] +"\n";
            if(selectedItens[2] != "")
                msg+= selectedItens[2]+" R$ "+ priceItens[2] +"\n";
            msg+="-------------------\n";
            
            Object[] options = { "CONFIRMAR PEDIDO", "REMOVER ITEM"};
            this.confirm = JOptionPane.showOptionDialog(null,msg+"Total:  R$ "+this.precoTotal,
                    null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE ,
                    null, options, options[0]);
        }
    }

    /**
     * Metodo para remover um pedido
     * @param pedido Pedido realizado pelo cliente
     */
    public void removerPedido(Pedido pedido){
        for(int i=0; i<3; i++)
            this.itens.add(selectedItens[i]);

        this.deleteItem = JOptionPane.showInputDialog(null,"Pedidos: ", "Remover Pedido",
            JOptionPane.INFORMATION_MESSAGE, null, this.selectedItens, "");
        
        for (int i=0; i<selectedItens.length; i++){
            if (deleteItem.equals(itens) == true) 
                this.pos = i;
            if (deleteItem.equals(selectedItens[i])){
                this.selectedItens[i]="";
                this.precoTotal -= this.priceItens[i];
            }
        }
        pedido.removeItem(this.pos);
    }

    /**
     * Metodo para confirmar o pedido e ir para opçao de pagamento
     * @return confirmacao do pedido
     */
    public boolean confirmaPedido(){
        return (this.confirm == 0) ? true : false;
    }
}
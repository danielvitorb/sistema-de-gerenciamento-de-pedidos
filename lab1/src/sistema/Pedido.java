package sistema;
import java.util.ArrayList;

public class Pedido {
	private String nomeDoCliente;
	private static int proxNumeroDoPedido = 0;
	private int  numeroDoPedido;
	private ArrayList<Item> itens;
	
	public Pedido(String nome) {
		numeroDoPedido = ++proxNumeroDoPedido;
		nomeDoCliente = nome;
		itens = new ArrayList<Item>();
	}
	
	public void setNomeDoCliente(String nome) {
		nomeDoCliente = nome;
	}
	
	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
	
	public int getNumeroDoPedido() {
		return  numeroDoPedido;
	}
	
	public void adicionarItem(Item produto) {
		itens.add(produto);
	}
	
	public int getQtdItens() {
		return itens.size();
	}
	
	public Item getItem(int pos) {
		return itens.get(pos);
	}
}
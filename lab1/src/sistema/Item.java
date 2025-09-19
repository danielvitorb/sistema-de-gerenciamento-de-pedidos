package sistema;

public class Item {
	private String nome;
	private double preco;
	
	public Item(String nome, double valor) {
		this.nome = nome;
		this.preco = valor;
	}
	
	public void setNomeItem(String nomeItem) {
		nome = nomeItem;
	}
	
	public void setprecoItem(double valor) {
		preco = valor;
	}
	
	public String getNomeItem() {
		return nome;
	}
	
	public double getPrecoItem() {
		return preco;
	}
}
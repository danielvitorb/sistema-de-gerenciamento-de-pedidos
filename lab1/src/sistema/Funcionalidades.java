package sistema;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Funcionalidades {
	
	public void imprimirNota(Pedido pedido) {
		double total = 0;
		System.out.println("\n========================================");
		System.out.println(" Restaurante Tempero Digital ");
		System.out.println("========================================");
		System.out.println("Pedido N°: " + pedido.getNumeroDoPedido());
		System.out.println("Cliente: " + pedido.getNomeDoCliente());
		System.out.println("----------------------------------------");
		System.out.println("Itens:");
		
		for (int i = 0; i < pedido.getQtdItens(); i++) {
			System.out.println("- " + pedido.getItem(i).getNomeItem() + " R$ " + pedido.getItem(i).getPrecoItem());
			total += pedido.getItem(i).getPrecoItem();
		}
		System.out.println("----------------------------------------");
		System.out.println("Total: R$ " + total);
		System.out.println("========================================");
		System.out.println(" Obrigado pela preferência! :) ");
		System.out.println("========================================\n");
	}
	
	public void registrarPedido(ArrayList<Pedido> pedidos) {
		Scanner leitor = new Scanner(System.in);
		String nomeCliente, nomeItem;
		double precoItem = 0;
		Funcionalidades func = new Funcionalidades();
		
		System.out.println("Qual o seu nome?");
		nomeCliente = leitor.nextLine();
		
		Pedido pedido = new Pedido(nomeCliente);
		
		boolean continuarAdicionando = true;
		while (continuarAdicionando) {
			System.out.println("O que você deseja pedir?");
			nomeItem = leitor.nextLine();
			
			boolean precoValido = false;
			while(!precoValido) {
				try {
					System.out.println("Qual o preço?");
					precoItem = leitor.nextDouble();
					precoValido = true;
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, digite um valor numérico para o preço.");
	                leitor.nextLine();
				}
			}
			leitor.nextLine();
			
			Item item = new Item(nomeItem, precoItem);
			pedido.adicionarItem(item);
			
			boolean respostaValida = false;
	        while (!respostaValida) {
	            System.out.println("Deseja adicionar mais alguma coisa? [s/n]");
	            String condicao = leitor.nextLine();

	            if (condicao.equalsIgnoreCase("s")) {
	                respostaValida = true;
	            } else if (condicao.equalsIgnoreCase("n")) {
	                continuarAdicionando = false; 
	                respostaValida = true;
	            } else {
	                System.out.println("Por favor, digite 's' para sim ou 'n' para não.");
	            }
	        }
		}
		
		func.imprimirNota(pedido);
		pedidos.add(pedido);
	}
	
	public void mostrarMenu() {
		System.out.println("Escolha uma opção: ");
		System.out.println("[1] Registrar Pedido");
		System.out.println("[2] Remover Pedido");
		System.out.println("[3] Listar Pedidos");
		System.out.println("[4] Sair");
	}
	
	public void removerPedido(int numPedido, ArrayList<Pedido> pedidos) {
		if (pedidos.isEmpty()) {
			System.out.println("Não há pedidos!");
			return;
		} else {
			for (int i = 0; i < pedidos.size(); i++) {
				if (numPedido == pedidos.get(i).getNumeroDoPedido()) {
					pedidos.remove(i);
					System.out.println("Pedido N°: " + numPedido + " removido com sucesso!");
					return;
				}
			}
		}
		System.out.println("Erro: Não existe nenhum pedido de N°: " + numPedido);
	}
	
	public void listarPedidos(ArrayList<Pedido> pedidos) {
		if(pedidos.isEmpty()) {
			System.out.println("Erro: Não há pedidos!");
			return;
		} else {
			System.out.println("\n========================================");
			System.out.println(" Restaurante Tempero Digital ");
			System.out.println("========================================");
			for (int i = 0; i < pedidos.size(); i++) {
				double total = 0;
				System.out.println("Pedido N°: " + pedidos.get(i).getNumeroDoPedido());
				System.out.println("Cliente: " + pedidos.get(i).getNomeDoCliente());
				System.out.println("----------------------------------------");
				System.out.println("Itens:");
				
				for (int j = 0; j < pedidos.get(i).getQtdItens(); j++) {
					System.out.println("- " + pedidos.get(i).getItem(j).getNomeItem() + " R$ " + pedidos.get(i).getItem(j).getPrecoItem());
					total += pedidos.get(i).getItem(j).getPrecoItem();
				}
				System.out.println("----------------------------------------");
				System.out.println("Total: R$ " + total);
				System.out.println("\n");
			}
		}
	}
}
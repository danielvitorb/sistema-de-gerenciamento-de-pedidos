package sistema;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		int x, numPedido;
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		Funcionalidades func = new Funcionalidades();
		
		System.out.println("Bem vindo ao Tempero Digital!!!");
		do {
			try {
				func.mostrarMenu();
				x = leitor.nextInt();
				switch (x) {
					case 1:
						func.registrarPedido(pedidos);
						break;
						
					case 2:
						System.out.println("Qual o número do pedido que deseja remover?");
						numPedido = leitor.nextInt();
						func.removerPedido(numPedido, pedidos);
						break;
						
					case 3:
						func.listarPedidos(pedidos);
						break;
						
					case 4:
						System.out.println("Obrigado pela preferência e volte sempre!");
						break;
						
					default:
						System.out.println("Entrada inválida! Por favor, escolha uma opção de 1 a 4.");
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("Entrada inválida! Por favor, escolha uma opção de 1 a 4.");
		        leitor.next();
		        x = 0;
			}
		} while(x != 4);
		leitor.close();
	}

}
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class TerminalDeSenhas {
	
	public static void gerarSenha(String senha) {
		try {
			
			Socket socket = new Socket("127.0.0.1", 12345);
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			saida.writeObject(senha);
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner tc = new Scanner(System.in);
		int op, normal = 0, priori = 0;
		
		while(true) {
			System.out.println("Terminal de Senhas");
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Senha Normal");
			System.out.println("2 - Senha Prioritária");
			op = tc.nextInt();
			
			switch (op) {
			case 1:
				normal = normal + 1;
				gerarSenha("N"+normal);
				
				break;
	
			case 2:
				priori = priori + 1;
				gerarSenha("P"+priori);
				
				break;
				
			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
		}	
	}

}

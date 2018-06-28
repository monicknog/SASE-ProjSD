import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TerminalDeAtendimento {
	
	static Senha senha = new Senha();
	
	public static void solicitarSenha(String str) {
		try {
			
			Socket socket = new Socket("127.0.0.1", 12345);
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			saida.writeObject(str);
			
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner tc = new Scanner(System.in);
		String op;
		
		while (true) {
			System.out.println();
			System.out.println("Terminal de Atendimento");
			System.out.println("Solicitar senha?");
			System.out.println("S - Sim");
			System.out.println("N - N�o");
			op = tc.nextLine();
			
			switch (op) {
			case "S":
				solicitarSenha("SIM");
				break;

			case "N":
				break;
				
			default:
				System.out.println("Selecione uma op��o v�lida.");
				break;
			}
			
		}
		
	}

}

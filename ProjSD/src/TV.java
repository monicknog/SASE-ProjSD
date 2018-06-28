import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TV {
	
	static String senha;
	
	public static void apresentarSenha() {
		ServerSocket servidorTV;
		try {
			servidorTV = new ServerSocket(7778);
			
			Socket socket = servidorTV.accept();
			
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			senha = in.readLine();

			Scanner entrada = new Scanner(socket.getInputStream());
			senha = entrada.nextLine();
			
	        System.out.println("SENHA: " + senha);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			apresentarSenha();
		}
	}

}

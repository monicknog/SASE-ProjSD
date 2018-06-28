import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Servidor {
		
		public static List<String> senhas = new LinkedList<>();
		public static void main(String[] args) {
			
			try {
				
				//INSTANCIA DO SERVIDOR SOCKET
				ServerSocket servidor = new ServerSocket(12345);
				System.out.println("Servidor Iniciado!");
				
				while (true) {
					//SERVIDOR NA ESCUTADA DA PORTA 12345
					Socket socket = servidor.accept();
					new Thread(new ServidorCliente(socket, null)).start();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

		class ServidorCliente implements Runnable{
			private Socket socket;
			
			public ServidorCliente(Socket socket, String string) {
				// TODO Auto-generated constructor stub
				this.socket = socket;
			}

			@Override
			public void run() {
					try {
						Scanner entrada = new Scanner(socket.getInputStream());
			            String string = entrada.nextLine();
						
						if(string.contains("SIM")) {
							System.out.println("ENTREII");
							pedirSenha(socket);
						}else {
							if(string.contains("N")) {
								Servidor.senhas.add(string.substring(7));
								System.out.println("Senha adicionada na fila! - NORMAL");
							}else if(string.contains("P")) {
								Servidor.senhas.add(0, string.substring(7));
								System.out.println("Senha adicionada na fila!");
							}
							
							entrada.close();
							socket.close();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
			
			
			private synchronized void pedirSenha(Socket socket) {
				// TODO Auto-generated method stub
				String str;
				
				System.out.println(Servidor.senhas);
				
				if(Servidor.senhas.isEmpty()) {
					System.out.println("Não há senhas!");
				}else {
					str = Servidor.senhas.get(0);
					Servidor.senhas.remove(0);
					
					try {
						
						
						Socket socketTV = new Socket("127.0.0.1", 7778);
						
						
						
						PrintWriter out=new PrintWriter(socketTV.getOutputStream(), true);
//						PrintWriter out = new PrintWriter(socketTV.getOutputStream(), true);
		                out.println(str);
						
//						ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
	//					saida.writeChars(str);
						
				
						socketTV.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			}	
			
		}

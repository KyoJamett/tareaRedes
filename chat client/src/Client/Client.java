package Client;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class Client {
	
	private static final String ip = "127.0.0.1";
	private static final int port = 19;
	
	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintStream ps;
	
	public Client() {
		try {
			socket = new Socket(ip, port);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Hubo problemas al conectarse con el servidor", "UnknownHostException", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
		
	public String receiveMessage() {
		String received = "";
		try {
			if(bufferedReader.ready() == true)
				received = bufferedReader.readLine();
			else
				return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return received;
	}
	
	public void sendMessage(String message) {
		if(message != null) {
			ps.println(message);
		} else {
			System.out.println("Server die");
			System.exit(0);
		}
	}
	
	public void close() {
		try {
			socket.close();
			bufferedReader.close();
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

	
/*	public Client(){
		Socket kkSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			kkSocket = new Socket("localhost", 4444);
			out = new PrintWriter(kkSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: manis.csi.ull.es.");
//			vp.modificarTexto("Don't know about host: manis.csi.ull.es.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
//			vp.modificarTexto("Couldn't get I/O for the connection to: manis.csi.ull.es.");
			System.exit(1);
		}

		//Recibir mensaje
		
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;

		try{
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
//				vp.modificarTexto("Server: " + fromServer);
				if (fromServer.equals("Bye."))
					break;
				
				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client: " + fromUser);
//					vp.modificarTexto("Client: " + fromUser);
					out.println(fromUser);
				}
			}

			out.close();
			in.close();
			stdIn.close();
			kkSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/	




/*	final String HOST = "localhost";
final int PUERTO = 8888;
Socket sc;
DataOutputStream mensaje;
DataInputStream entrada;

public void initClient(){
	VentanaPrincipal vp = new VentanaPrincipal();
	vp.setVisible(true);
	
	try{
		sc = new Socket(HOST, PUERTO); //conectar a un servidor en localhost con puerto 5000
		
		//creamos el flujo de datos por el que se enviara un mensaje
		mensaje = new DataOutputStream(sc.getOutputStream());
		
		//enviamos el mensaje
		vp.modificarTexto("hola que tal!!");
		mensaje.writeUTF("hola que tal!!");
		
		//cerramos la conexi�n
		sc.close();
	}catch(Exception e ){
		vp.modificarTexto("Error: "+e.getMessage());
	}
}*/
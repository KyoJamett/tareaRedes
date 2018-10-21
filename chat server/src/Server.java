import java.net.*;
import java.util.Scanner;

import java.io.*;

public class Server {
	
	private String message, temp;
	private ServerSocket serverSocket;
	private Socket socket;
	private Scanner keyboardScan;
	private PrintStream ps;	
	
	public Server() {
		try {
			serverSocket = new ServerSocket(19);
			System.out.println("Server Socket creado");
			socket = serverSocket.accept();
			System.out.println("Socket creado");
			keyboardScan = new Scanner(socket.getInputStream());
			System.out.println("Scanner creado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initServer() {
		while(true) {
			if(keyboardScan.hasNextLine()) {
				receiveMessage();
				sendMessage(socket);
			}
		}
	}
	
	public void sendMessage(Socket socket) {
		try {
			temp = "Hola Cliente, recib� este mensaje:";
			ps = new PrintStream(socket.getOutputStream());
			ps.println(temp + " " + message);
			System.out.println(temp + " " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveMessage() {
		message = keyboardScan.nextLine();
	}
	
	/*final int PUERTO = 8888;
	ServerSocket sc;
	Socket so;
	DataOutputStream salida;
	String mensajeRecibido;

	public void initServer(){
		//Muestra la interfaz grafica del servidor
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);
		
		//Se crea un socket
		ServerSocket serverSocket = null;
        try {
			serverSocket = new ServerSocket(4444);
			vp.modificarTexto("estoy despues de crear el socket");
	    	System.out.println("estoy despues de crear el socket");
        } catch (IOException e) {
			vp.modificarTexto("Could not listen on port: 4444.");
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
			clientSocket = serverSocket.accept();
			vp.modificarTexto("estoy despues de aceptar un cliente");
	    	System.out.println("estoy despues de aceptar un cliente");
        } catch (IOException e) {
			System.err.println("Accept failed.");
			vp.modificarTexto("Accept failed.");
            System.exit(1);
        }

		try{
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					clientSocket.getInputStream()));
			String inputLine, outputLine;

			outputLine = "asdf";
			out.println(outputLine);
			vp.modificarTexto(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = inputLine;
				out.println(outputLine);
				vp.modificarTexto(outputLine);
				if (outputLine.equals("Bye."))
					break;
			}
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e){
			e.printStackTrace();
		}*/
		/*BufferedReader entrada;
		try{
			sc = new ServerSocket(PUERTO);// crea socket servidor que escuchara en puerto
			so = new Socket();
			vp.modificarTexto("Esperando una conexi�n:");
			so = sc.accept();
			
			//Inicia el socket, ahora esta esperando una conexion por parte del cliente
			vp.modificarTexto("Un cliente se ha conectado.");
			
			//Canales de entrada y salida de datos
			entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
			salida = new DataOutputStream(so.getOutputStream());
			vp.modificarTexto("Confirmando conexion al cliente....");
			vp.modificarTexto("Conexion exitosa...n envia un mensaje :D");
			salida.writeUTF("Conexion exitosa...n envia un mensaje :D");
			
			//Recepcion de mensaje
			mensajeRecibido = entrada.readLine();
			vp.modificarTexto(mensajeRecibido);
			vp.modificarTexto("Se recibio tu mensaje.n Terminando conexion...");
			salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
			vp.modificarTexto("Gracias por conectarte, adios!");
			salida.writeUTF("Gracias por conectarte, adios!");
			vp.modificarTexto("Cerrando conexion...");
			sc.close();//Aqui se cierra la conexi�n con el cliente
		}catch(Exception e ){
			vp.modificarTexto("Error: " + e.getMessage());
		}*/
}
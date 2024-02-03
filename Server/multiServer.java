import java.net.*;
import java.io.*;

//Classe Server per attivare la Socket
public class multiServer {
    public void start() throws Exception {
      ServerSocket serverSocket = new ServerSocket(7777);
  
        //Ciclo infinito di ascolto dei Client
        while(true){
            System.out.println(" Attesa ");
            Socket socket = serverSocket.accept();
            System.out.println("Ricezione una chiamata di apertura da:\n" + socket.getInetAddress());
            //avvia il processo per ogni client 
            server serverThread = new server(socket);
            serverThread.start();
        }
    }
  
        public static void main (String[] args) throws Exception {
        multiServer multiServer = new multiServer();
        multiServer.start();
    }
}
   
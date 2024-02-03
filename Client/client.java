import java.net.*; 
import java.io.*; 

public class client { 
    private Socket socket;
    private BufferedReader is;
    private DataOutputStream os;

    public void start()throws IOException { 
        //Connessione della Socket con il Server 
        this.socket = new Socket("127.0.0.1", 7777); 

        //Stream di byte da passare al Socket 
        os = new DataOutputStream(socket.getOutputStream()); 
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String userInput;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.print("Scrivere help per la lista comandi\n"); 

        //Ciclo infinito per inserimento testo del Client 
        do{ 
            System.out.print("Inserisci: "); 
            userInput = stdIn.readLine();

            os.writeBytes(userInput + '\n'); 
            os.flush();

            System.out.println("Server: ");
            String serverResponse;

            //tentativo di leggere la risposta multilinea del server
            /* while ((serverResponse = is.readLine()) != null) {
                System.err.println(serverResponse);
            } */

            serverResponse = is.readLine();
            System.out.println(serverResponse);

        } while(!userInput.equals("exit"));

        //Chiusura dello Stream e del Socket 
        os.close(); 
        is.close(); 
        socket.close(); 
    } 
    
    public static void main (String[] args) throws Exception { 
        client client = new client(); 
        client.start(); 
    } 
}
package lopreiato.it;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("client avviato!");

        Socket s = new Socket("localhost", 3000);
        
        System.out.println("Il client si è collegato!");
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        

        String numero; // numero da inserire
        String rispostaServer;
        Scanner scanner = new Scanner(System.in);
        
        do{
            System.out.println("Inserire un numero compreso tra 0 a 100: ");
            numero = scanner.nextLine(); // numero inserito dal client da input
            out.writeBytes(numero + "\n"); // invia il numero al server
            rispostaServer = in.readLine();
            System.out.println("Risposta del server: " + rispostaServer + "\n");
        }while (rispostaServer == "TOO_LOW" || rispostaServer == "TOO_HIGH");

        s.close();
        scanner.close();
    }
}
import java.net.*;
import java.io.*;

public class server {
    
    public static void main (String[] args) throws IOException {
        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket serv = new ServerSocket(2000);
       	System.out.println("Waiting...");
        Socket client = serv.accept();
        
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        String m = in.readLine();
        System.out.println("Client sent: ");
        System.out.println(m);
        
        System.out.println("Enter server's response: ");
        out.println(cmd.readLine());
        System.out.println("Done!");
    }
}

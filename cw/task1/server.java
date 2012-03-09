import java.net.*;
import java.io.*;

public class server {
    
    public static void main (String[] args) {
        try {
        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket serv = new ServerSocket(2000);
       	System.out.println("Waiting...");
        Socket client = serv.accept();
        
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(client.getInputStream());
        
        String m = (String) in.readObject();
        System.out.println("Client sent: ");
        System.out.println(m);
        
        System.out.println("Enter server's response: ");
        m = cmd.readLine();
        out.writeObject(m);
        System.out.println("Done!");
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(0);
        } catch (ClassNotFoundException cnf) {
            System.err.println(cnf.getMessage());
            System.exit(0);
        }
    }
}

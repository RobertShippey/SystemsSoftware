import java.net.*;
import java.io.*;

public class client {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the IP Address of the server");
            String ip = cmd.readLine();
            
            Socket soc = new Socket(ip, 2000);
            
            ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
            
            
            String m;
            System.out.println("Enter message to send to server: ");
            m = cmd.readLine();
            out.writeObject(m);
            
            m = (String)in.readObject();
            System.out.println("Server send back: ");
            System.out.println(m);
            System.out.println("Done!");
        } catch (UnknownHostException uhe) {
            System.err.println(uhe.getMessage());
            System.err.println("Could not connect to the server.");
            System.exit(0);
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Communication could not be established.");
            System.exit(0);
        } catch (ClassNotFoundException cnf) {
            System.err.println(cnf.getMessage());
            System.err.println("The server send something weird back. Appologies.");
            System.exit(0);
        }
        
        
    }
    
}

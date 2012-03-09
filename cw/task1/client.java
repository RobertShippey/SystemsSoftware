import java.net.*;
import java.io.*;

public class client {

public static void main(String[] args) throws IOException{

	BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the IP Address of the server");
	String ip = cmd.readLine();
    //172.19.115.213

	Socket soc = new Socket(ip, 2000);
    
    PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));


    System.out.println("Enter message to send to server: ");
    out.println(cmd.readLine());

    String m = in.readLine();
    System.out.println("Server send back: ");
    System.out.println(m);
	

}

}

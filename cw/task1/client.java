import java.net.*;
import java.io.*;

public class client {
    
    public static void main(String[] args) throws Exception {
        
                      BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
                      System.out.println("Enter the IP Address of the server");
                      String ip = cmd.readLine();
        InetAddress serverIP = InetAddress.getByName(ip);
        int serverPort = 2000;
        
        byte[] Nnumber = "N0305434".getBytes();
        
        DatagramSocket serverSocket = new DatagramSocket();
        DatagramPacket sendingPacket = new DatagramPacket(Nnumber, Nnumber.length, serverIP, serverPort);
        serverSocket.send(sendingPacket);
        
        byte[] buffer = new byte[50];
        DatagramPacket receivingPacket = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(receivingPacket);
        
        String text = new String(receivingPacket.getData(), 0, receivingPacket.getLength());
        
        System.out.println(text);
        
              
        
    }
    
}

import java.net.*;
import java.io.*;

public class server {
    
    public static void main (String[] args) throws Exception {
        
        DatagramSocket mySocket = new DatagramSocket(2000);
        
        byte[] buffer = new byte[50];
        DatagramPacket recievedPacket = new DatagramPacket(buffer, buffer.length);
        mySocket.receive(recievedPacket);
        
        String text = new String (recievedPacket.getData(), 0, recievedPacket.getLength());
       System.out.println(text);
        
        byte[] myName = "Robert Shippey".getBytes();
        
        InetAddress clientIP = recievedPacket.getAddress();
        int clientPort = recievedPacket.getPort();
        DatagramPacket sendingPacket = new DatagramPacket(myName, myName.length, clientIP, clientPort);
        mySocket.send(sendingPacket);

    }
}

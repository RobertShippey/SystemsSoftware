
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server {

    public static void main(String[] args) {

        try {
            DatagramSocket mySocket = new DatagramSocket(2000);

            byte[] buffer = new byte[50];
            DatagramPacket recievedPacket = new DatagramPacket(buffer, buffer.length);
            mySocket.receive(recievedPacket);

            String text = new String(recievedPacket.getData(), 0, recievedPacket.getLength());
            System.out.println(text);

            byte[] myName = "Robert Shippey".getBytes();

            InetAddress clientIP = recievedPacket.getAddress();
            int clientPort = recievedPacket.getPort();
            DatagramPacket sendingPacket = new DatagramPacket(myName, myName.length, clientIP, clientPort);
            mySocket.send(sendingPacket);
            
            mySocket.close();
            
        } catch (SocketException se) {
            System.err.println(se.getMessage());
            System.err.println("Could not reserver port 2000");
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.err.println("Could not send/recieve message");
            System.exit(0);
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class client {

    public static void main(String[] args) {

        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
        InetAddress serverIP = null;
        int serverPort = 2000;

        System.out.println("Enter the IP Address of the server");

        try {
            String ip = cmd.readLine();
            serverIP = InetAddress.getByName(ip);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.err.println("Could not reach the specified IP address");
            System.exit(0);
        }

        byte[] Nnumber = "N0305434".getBytes();

        try {
            DatagramSocket serverSocket = new DatagramSocket();
            DatagramPacket sendingPacket = new DatagramPacket(Nnumber, Nnumber.length, serverIP, serverPort);
            serverSocket.send(sendingPacket);

            byte[] buffer = new byte[50];
            DatagramPacket receivingPacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivingPacket);

            
            String text = new String(receivingPacket.getData(), 0, receivingPacket.getLength());

            System.out.println(text);
            
            serverSocket.close();

        } catch (SocketException se) {
            System.err.println(se.getMessage());
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.exit(0);
        }
    }
}

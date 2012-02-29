import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetGame {
    private ServerSocket _servSock;
    private Socket _socket;
    private BufferedReader in;
    private BufferedWriter out;
    

    public NetGame() throws IOException {
        _servSock = new ServerSocket(2000);
    }
    
    public void setup(String opponent)throws IOException{
        _socket = new Socket(opponent, 2000);
        _servSock.bind(_socket.getLocalSocketAddress());
        out = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
    }
    
    
    public void sendMove(int x, int y) throws IOException {
            out.write(x);
            out.write(y);
            out.flush();
    }
    
    public int[] recieveMove() {
       int[] move = new int[2];
       try{
        move[0] = in.read();
        move[1] = in.read();
        return move;
       } catch (IOException e) {
           return null;
       }
    }
    
}

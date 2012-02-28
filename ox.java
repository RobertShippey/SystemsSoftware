import java.io.*;
public class ox {
    
    private String[][] board = new String[3][3];
    private boolean won = false;
    private boolean draw = false;
    private String player = "O";
    
    public static void main(String[] args) throws IOException{
        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
        ox game = new ox();
        String go;
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("You know the rules!");
        System.out.println("Enter coords xy (eg, 21). x is row, y is column.");
        while(!game.hasEnded()){
            System.out.println(game.player() + ": Enter your position... ");
            game.takeTurn(cmd.readLine());
            game.draw();
        }
        
        
    }
    
    public ox() {
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<3;x++)
            {
                board[x][y] = " ";
            }
        }
    }
    
    public boolean hasEnded() {
        
        check();
        
        if(won || draw)
        {
            return true;
        }
        return false;
    }
    
    public void draw() {
        for(int x=0;x<3;x++)
        {
            System.out.print("|");
            for(int y=0;y<3;y++)
            {
                System.out.print(board[x][y]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }
    
    public String player() {
        if(player.equals("X")){
            return "X";
        } else if (player.equals("O")) {
            return "O";
        }
        return "ERR";
    }
    public void takeTurn(String go) {
        int x,y;
        x = Integer.parseInt(go.substring(0,1));
        y = Integer.parseInt(go.substring(1,2));
        board[x][y] = player;
        nextPlayer();
    }
    private void nextPlayer(){
        if(player.equals("X")){
            player = "O";
        } else if (player.equals("O")) {
            player = "X";
        }
    }
    
    private void check(){
        //do logic in here
    }
    
}
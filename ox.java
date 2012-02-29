import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tic-Tac-Toe game.
 * @author Robert Shippey
 */
public class ox {

    private String[][] _board = new String[3][3];
    private boolean _won;
    private boolean _draw;
    private String _player;
    private int _turns;
    private boolean _invalid;

    /**
     * Entry point.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));
        ox game = new ox();

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("You know the rules!");
        System.out.println("Enter coords xy (eg, 21). x is row, y is column.");

        game.draw();
        while (!game.hasEnded()) {
            do{
                if(game.inputInvalid()){
                    System.out.println("There was something wrong with your input");
                    System.out.println("Enter coords xy (eg, 21). x is row, y is column.");}
                System.out.println(game.getPlayer() + ": Enter your position... ");
                game.takeTurn(cmd.readLine());
            }
            while(game.inputInvalid());
            game.draw();
        }

        if (game.winner() != null) {
            System.out.println("Player " + game.winner() + " wins with " + game.getTurns() + " turns.");
        } else {
            System.out.println("The game was a draw!");
        }
        return;
    }

    /**
     *  Constructs a game ready to be played.
     */
    public ox() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                _board[x][y] = " ";
            }
        }

        _won = false;
        _draw = false;
        _player = "O";
        _turns = 0;
        _invalid = false;
    }

    /**
     * 
     * @return true when the game has finished.
     */
    public boolean hasEnded() {

        check();

        if (_won || _draw) {
            return true;
        }
        return false;
    }

    /**
     * Draw the game state to screen
     */
    public void draw() {
        for (int x = 0; x < 3; x++) {
            System.out.print("|");
            for (int y = 0; y < 3; y++) {
                System.out.print(_board[x][y]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    /**
     * 
     * @return the current player's token (O or X)
     */
    public String getPlayer() {
        return _player;
    }

    /**
     * Adds the player's token to the board, increments the turns and finally switches player.
     * @param go is the string entered by the user
     */
    public void takeTurn(String go) {
        int x, y;
        try {
            x = Integer.parseInt(go.substring(0, 1));
            y = Integer.parseInt(go.substring(1, 2));
            _board[x][y] = _player;
        } catch (Exception e) {
            //System.err.println(e);
            _invalid = true;
            return;
        }
        _invalid = false;
        _turns++;
        nextPlayer();
    }

    /**
     *  Moves the game state to the the next player.
     */
    private void nextPlayer() {
        if (_player.equals("X")) {
            _player = "O";
        } else if (_player.equals("O")) {
            _player = "X";
        }
    }

    /**
     * 
     * @return the number of turns taken.
     */
    public int getTurns() {
        return _turns;
    }

    /**
     *  Checks the board for a win. If so, sets internals to represent it.
     */
    private void check() {
        if(_turns<3){
            return;
        }
        if (_turns == 9) {
            _draw = true;
        }
        //do logic in here

    }

    /**
     * 
     * @return the token of the winner (O or X). Null if no winner (draw or the game is not over).
     */
    public String winner() {
        if (_won) {
            return _player;
        }

        return null;
    }
    /**
     *
     *@return true if the input was wrong.
     */
    public boolean inputInvalid(){
        return _invalid;
    }
}
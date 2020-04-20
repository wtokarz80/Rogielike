import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    
    private Player player;
    private GameObject apple;
    private final int width = 20;
    private final int height = 20;


    public Game() {
        player = new Player();
        Coordinates applecoo1 = new Coordinates(12, 7);
        apple = new Apple(applecoo1);

    }

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                player.move(new Coordinates(-1, 0));
                break;
            case 's':
                player.move(new Coordinates(1, 0));
                break;
            case 'a':
                player.move(new Coordinates(0, -1));
                break;
            case 'd':
                player.move(new Coordinates(0, 1));
                break;   
        }
        System.out.println(player.getCoord().toString());
        printBoard();
    }

    private void printBoard() {
        String[][] board  = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();
        board[this.apple.getCoordinates().getX()][this.apple.getCoordinates().getY()] = apple.getSymbol();

        for(int i = 0; i< width;  i++) {
            for(int j = 0; j< height; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print(" .");
            }
            System.out.println();
        }
    }
}
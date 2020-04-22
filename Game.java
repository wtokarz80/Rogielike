import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {
    
    private Player player;
    private ObstaclesList obstacles;
    private GameObject key;
    private Food apple1;
    private Food apple2;
    private final int width = 30;
    private final int height = 30;



    public Game() {
        obstacles = new ObstaclesList();
        player = new Player();
        key = new Key("key","\ud83d\udddd\ufe0f ", new Coordinates(21, 20), 1, 1);
        apple1 = new Food("apple", "\ud83c\udf4e", new Coordinates(11, 11), 1, 1);
        apple2 = new Food("apple", "\ud83c\udf4e", new Coordinates(16, 13), 1, 1);
        printBoard();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Common.clearScreen();
        char ch = event.getKeyChar();
        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                if (canPlayerMove(Coordinates.W)){
                    player.move(Coordinates.W);
                }
                break;
            case 's':
                if (canPlayerMove(Coordinates.S)){
                    player.move(Coordinates.S);
                }
                break;
            case 'a':
                if (canPlayerMove(Coordinates.A)){
                    player.move(Coordinates.A);
                }
                break;
            case 'd':
                if (canPlayerMove(Coordinates.D)){
                    player.move(Coordinates.D);
            }
                break;   
        }
        System.out.println(player.getCoord().toString());
        System.out.println(player.getInventory().toString());
        printBoard();
    }


    private void printBoard() {
        String[][] board  = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();

        if(this.player.getCoord().getX() == this.key.getPivot().getX() && this.player.getCoord().getY() == this.key.getPivot().getY())
            this.key.use(player);
        if(this.player.getCoord().getX() == this.apple1.getPivot().getX() && this.player.getCoord().getY() == this.apple1.getPivot().getY())
            this.apple1.use(player);
        if(this.player.getCoord().getX() == this.apple2.getPivot().getX() && this.player.getCoord().getY() == this.apple2.getPivot().getY())
            this.apple2.use(player);

        board[this.key.getPivot().getX()][this.key.getPivot().getY()] = key.getSymbol();
        board[this.apple1.getPivot().getX()][this.apple1.getPivot().getY()] = apple1.getSymbol();
        board[this.apple2.getPivot().getX()][this.apple2.getPivot().getY()] = apple2.getSymbol();


        printObstacles(board);

        for(int i = 0; i< width;  i++) {
            for(int j = 0; j< height; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private void printObstacles(String[][] board){
        for (Obstacle obstacle : obstacles.getObstacles()){
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for(int i = pivot.getX(); i < pivot.getX()+height; i++){
                for(int j = pivot.getY(); j < pivot.getY()+width; j++){
                    board[i][j] = obstacle.getSymbol();
                }
            }
        }
    }

    public boolean canPlayerMove(Coordinates coord){
        for (Obstacle obstacle : obstacles.getObstacles()){
            if (isPlayerInRange(obstacle, coord)){
                obstacle.use(player);
                return false;
            }
        }
        if (isPlayerInRange(key, coord)){
            key.use(player);
            return false;
        }
        return true;
    }

    private boolean isPlayerInRange(GameObject obstacle, Coordinates coord){
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoord().getX() + coord.getX();
        int y = this.player.getCoord().getY() + coord.getY();

        return x >= pivot.getX() && x < pivot.getX() + height
            && y >= pivot.getY() && y < pivot.getY() + width;
    }
}
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {
    
    private Player player;
    private GameObject apple;
    private final int width = 20;
    private final int height = 20;
    private ArrayList<Obstacle> obstacles;


    public Game() {
        player = new Player();
        obstacles = new ArrayList<>();
        createObstacles();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Common.clearScreen();

        char ch = event.getKeyChar();

        System.out.println((int)ch);
        Coordinates W = new Coordinates(-1, 0);
        Coordinates S = new Coordinates(1, 0);
        Coordinates A = new Coordinates(0, -1);
        Coordinates D = new Coordinates(0, 1);


        switch(ch) {
            case 'w':
                if (canPlayerMove(W)){
                    player.move(W);
                }
                break;
            case 's':
                if (canPlayerMove(S)){
                    player.move(S);
                }
                break;
            case 'a':
                if (canPlayerMove(A)){
                    player.move(A);
                }
                break;
            case 'd':
                if (canPlayerMove(D)){
                    player.move(D);
            }
                break;   
        }
        System.out.println(player.getCoord().toString());
        System.out.println("Player HP : " + player.stats.current_HP + "/" + player.stats.MaxHP);
        printBoard();
    }

    
    private void createObstacles(){
        Obstacle wall = new Obstacle(new Coordinates(0,0), width, 1, " #");
        Obstacle wall2 = new Obstacle(new Coordinates(0,0), 1, height, "#");
        Tree tree = new Tree(new Coordinates(7, 6), 1, 1, "\ud83c\udf32", "Tree");
        this.obstacles.add(wall);
        this.obstacles.add(wall2);
        this.obstacles.add(tree);
    }

    private void printBoard() {
        String[][] board  = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();

        printObstacles(board);

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

    private void printObstacles(String[][] board){
        for (Obstacle obstacle : obstacles){
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
        for (Obstacle obstacle : obstacles){
            if (isPlayerInRange(obstacle, coord)){
                obstacle.use(player);
                return false;
            }
        }
        return true;
    }

    private boolean isPlayerInRange(Obstacle obstacle, Coordinates coord){
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoord().getX() + coord.getX();
        int y = this.player.getCoord().getY() + coord.getY();

        return x >= pivot.getX() && x < pivot.getX() + height
            && y >= pivot.getY() && y < pivot.getY() + width;


    }
}
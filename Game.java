import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class Game extends KeyAdapter {

    private Player player;
    private EnemyList enemys;
    private ObstaclesList obstacles;
    private GameElementsList gameElements;
    private Baby baby;
    private final int width = 30;
    private final int height = 30;

    public Game() {
        enemys = new EnemyList();
        gameElements = new GameElementsList();
        obstacles = new ObstaclesList();

        player = new Player("Lolo", new Coordinates(2,2), new Statistics(1,0,10,10,10, 5, 5, 5), "\ud83d\udd7a");
        Common.displayStats(player);

        baby = new Baby("baby", new Coordinates(5, 27), new Statistics(1,0,10,10,10, 5, 5, 5), "\ud83d\udc83");

        printBoard();
        Common.displayInventory(player);

    }

    @Override
    public void keyPressed(KeyEvent event) {
        Common.clearScreen();
        char ch = event.getKeyChar();
        System.out.println((int) ch);

        switch (ch) {
            case 'w':
                if (canPlayerMove(Coordinates.W)) {
                    player.move(Coordinates.W);
                    baby.move(Coordinates.W, player, baby);
                }
                break;
            case 's':
                if (canPlayerMove(Coordinates.S)) {
                    player.move(Coordinates.S);
                    baby.move(Coordinates.S, player, baby);
                }
                break;
            case 'a':
                if (canPlayerMove(Coordinates.A)) {
                    player.move(Coordinates.A);
                    baby.move(Coordinates.A, player, baby);
                }
                break;
            case 'd':
                if (canPlayerMove(Coordinates.D)) {
                    player.move(Coordinates.D);
                    baby.move(Coordinates.D, player, baby);
                }
                break;
        }

        Common.displayStats(player);
        printBoard();
        Common.displayInventory(player);
    }

    private void printBoard() {
        String[][] board = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();
        board[this.baby.getCoord().getX()][this.baby.getCoord().getY()] = baby.getSymbol();

        printGameObjects(board);
        printEnemys(board);
        printObstacles(board);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private void printEnemys(String[][] board){
        for (Enemy enemy : enemys.getEnemyList()) {
            if (player.getCoord().getX() == enemy.getCoord().getX()
                    && player.getCoord().getY() == enemy.getCoord().getY())
                enemy.use(player);
            board[enemy.getCoord().getX()][enemy.getCoord().getY()] = enemy.getSymbol();
        }
    }

    private void printGameObjects(String[][] board){
        for (GameObject gameObject : gameElements.getGameElamenstList()) {
            if (this.player.getCoord().getX() == gameObject.getPivot().getX()
                    && this.player.getCoord().getY() == gameObject.getPivot().getY())
                gameObject.use(player);
            board[gameObject.getPivot().getX()][gameObject.getPivot().getY()] = gameObject.getSymbol();
        }
    }

    private void printObstacles(String[][] board) {
        for (Obstacle obstacle : obstacles.getObstacles()) {
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for (int i = pivot.getX(); i < pivot.getX() + height; i++) {
                for (int j = pivot.getY(); j < pivot.getY() + width; j++) {
                    board[i][j] = obstacle.getSymbol();
                }
            }
        }
    }

    public boolean canPlayerMove(Coordinates coord) {
        for (Obstacle obstacle : obstacles.getObstacles()) {
            if (isPlayerInRange(obstacle, coord)) {
                obstacle.use(player);
                return false;
            }
        }
        return true;
    }

    private boolean isPlayerInRange(GameObject obstacle, Coordinates coord) {
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoord().getX() + coord.getX();
        int y = this.player.getCoord().getY() + coord.getY();

        return x >= pivot.getX() && x < pivot.getX() + height && y >= pivot.getY() && y < pivot.getY() + width;
    }
}
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

class Game extends KeyAdapter {

    private Player player;
    private EnemyList enemys;
    private ObstaclesList obstacles;
    private GameElementsList gameElements;
    private Baby baby;
    private Ui userInterface; 
    private List<Enemy> enemysList;
    private List<Obstacle> obstaclesList;
    private List<GameObject> gameElementsList;
    private final int width = 30;
    private final int height = 30;

    public Game() {
        baby = new Baby("baby", new Coordinates(5, 27), new Statistics(1, 0, 10, 10, 10, 5, 5, 5), "\ud83d\udc83");
        enemys = new EnemyList();
        gameElements = new GameElementsList();
        obstacles = new ObstaclesList();
        player = Ui.createPlayer(player);
        userInterface= new Ui();
        Ui.clearScreen();
        System.out.println("Your stats " + player.getName());
        player.getStats().toString(); 
        printBoard();
        Ui.displayInventory(player);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Ui.clearScreen();
        try {
            isPlayerAlive(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            isPlayerOld(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        char ch = event.getKeyChar();
        // System.out.println((int) ch);

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
        System.out.println("Your stats " + player.getName());
        player.getStats().toString();
        printBoard();
        Ui.displayInventory(player);
    }

    private void isPlayerOld(Player player) throws IOException {
        if (player.getSymbol().equals("\ud83d\udc74")) {
            Ui.clearScreen();
            System.out.println("\n   End they lived happily ever after...     \n");
            System.out.println("Press enter to continue...");
            Ui.scan.next();
            userInterface.gameMenu();
        }
    }

    private void isPlayerAlive(Player player) throws IOException {
        if (player.getStats().getCurrentHP() <= 0) {
            Ui.clearScreen();
            System.out.println("\n        YOU LOSE\n");
            System.out.println("Press enter to continue...");
            Ui.scan.next();
            userInterface.gameMenu();
        }
    }

    private void printBoard() {
        String[][] board = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();
        if (baby.getIsInHouse(baby) == false) {
            board[this.baby.getCoord().getX()][this.baby.getCoord().getY()] = baby.getSymbol();
        }

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

    private void printEnemys(String[][] board) {
        if (baby.getIsInHouse(baby) == false) {
            enemysList = enemys.getEnemys1();
        } else {
            enemysList = enemys.getEnemys2();
        }
        for (Enemy enemy : enemysList) {
            if (player.getCoord().getX() == enemy.getCoord().getX()
                    && player.getCoord().getY() == enemy.getCoord().getY())
                enemy.use(player);
            board[enemy.getCoord().getX()][enemy.getCoord().getY()] = enemy.getSymbol();
        }
    }

    private void printGameObjects(String[][] board) {
        if (baby.getIsInHouse(baby) == false) {
            gameElementsList = gameElements.getGametElements1();
        } else {
            gameElementsList = gameElements.getGameElements2();
        }
        for (GameObject gameObject : gameElementsList) {
            if (this.player.getCoord().getX() == gameObject.getPivot().getX()
                    && this.player.getCoord().getY() == gameObject.getPivot().getY())
                gameObject.use(player);
            board[gameObject.getPivot().getX()][gameObject.getPivot().getY()] = gameObject.getSymbol();
        }
    }

    private void printObstacles(String[][] board) {
        if (baby.getIsInHouse(baby) == false) {
            obstaclesList = obstacles.getObstacles1();
        } else {
            obstaclesList = obstacles.getObstacles2();
        }
        for (Obstacle obstacle : obstaclesList) {
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
        if (baby.getIsInHouse(baby) == false) {
            obstaclesList = obstacles.getObstacles1();
        } else {
            obstaclesList = obstacles.getObstacles2();
        }
        for (Obstacle obstacle : obstaclesList) {
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
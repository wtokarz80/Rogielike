import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

class Game extends KeyAdapter {

    private Player player;
    private EnemyList enemys;
    private ObstaclesList obstacles;
    private GameElementsList gameElements;
    private Baby baby;
    private final int width = 30;
    private final int height = 30;

    public Game() {
        baby = new Baby("baby", new Coordinates(5, 27), new Statistics(1, 0, 10, 10, 10, 5, 5, 5), "\ud83d\udc83");
        enemys = new EnemyList();
        gameElements = new GameElementsList();
        obstacles = new ObstaclesList();
        player = Ui.createPlayer(player);
        Ui.clearScreen();
        Ui.displayStats(player);
        printBoard();
        Ui.displayInventory(player);

    }

    @Override
    public void keyPressed(KeyEvent event) {
        Ui.clearScreen();
        try {
            isPlayerAlive(player);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        Ui.displayStats(player);
        printBoard();
        Ui.displayInventory(player);
    }

    private void isPlayerAlive(Player player) throws IOException {
        if (player.getStats().getCurrentHP() <= 0){
            Ui.clearScreen();
            System.out.println("\n        YOU LOSE\n");
            System.out.println("Press enter to continue...");
            Ui.scan.next();
            System.exit(0);
        }
    }

    private void printBoard() {
        String[][] board = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();


        if (baby.getIsInHouse(baby) == false){ //but works here fine
        board[this.baby.getCoord().getX()][this.baby.getCoord().getY()] = baby.getSymbol();
        printGameObjects(board);
        printEnemys(board);
        printObstacles(board);
        }
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

    // public void Experience_get_and_lvl_Up() { // Will change later
    //     player.stats.exp += 3;
    //     if (player.stats.exp >= player.stats.expToLvl) {
    //         int experience_left = player.stats.exp - player.stats.expToLvl;
    //         player.stats.exp = 0 + experience_left;
    //         player.stats.expToLvl += 10;
    //         player.stats.lvl += 1;
    //         player.stats.maxHP += 2;
    //         player.stats.currentHP += 2;

    //     }   
    // }

    // public void Taking_dmg_and_death(){
    //     player.stats.currentHP -= 2;
    //     if (player.stats.currentHP <= 0){
    //         Common.clearScreen();
    //         System.out.println("Game over");
    //     }
    // }

    // public void Healing(){
    //     player.stats.currentHP += 1;
    //     if (player.stats.currentHP >= player.stats.maxHP){
    //         player.stats.currentHP = player.stats.maxHP;
    //     }
    // }
}
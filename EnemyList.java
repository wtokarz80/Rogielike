import java.util.ArrayList;
import java.util.List;

public class EnemyList {
    private List<Enemy> enemys1 = new ArrayList<>();
    private List<Enemy> enemys2 = new ArrayList<>();

    EnemyList() {
        createEnemys1();
        createEnemys2();

    }

    private void createEnemys1() {

        Enemy bandit = new Enemy("bandit", new Coordinates(14, 5), new Statistics(1, 0, 5, 5, 5, 5, 5, 5),
                "\ud83d\udc7a");
        Enemy ogre = new Enemy("ogre", new Coordinates(14, 10), new Statistics(1, 0, 5, 5, 5, 5, 10, 5),
                "\ud83d\udc79");
        Enemy ghost = new Enemy("ghost", new Coordinates(26, 8), new Statistics(1, 0, 5, 5, 5, 5, 5, 5),
                "\ud83d\udc7b");

        enemys1.add(bandit);
        enemys1.add(ogre);
        enemys1.add(ghost);

    }

    private void createEnemys2() {

        for (int i = 0; i < 9; i++) {
            Enemy crab = new Enemy("crab", new Coordinates(Ui.randInt(), Ui.randInt()),
                    new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
            enemys2.add(crab);
        }

        Enemy diablo = new Enemy("diablo", new Coordinates(14, 19), new Statistics(1, 0, 5, 5, 5, 5, 5, 5),
                "\ud83d\udc79");
        enemys2.add(diablo);
    }

    public List<Enemy> getEnemys1() {
        return enemys1;
    }

    public List<Enemy> getEnemys2() {
        return enemys2;
    }
}

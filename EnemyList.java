import java.util.ArrayList;
import java.util.List;

public class EnemyList {
    private List<Enemy> enemys = new ArrayList<>();

    EnemyList(){
        createEnemys();
    }

    private void createEnemys(){


        Enemy bandit = new Enemy("bandit", new Coordinates(14,5), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc7a");
        Enemy ogre = new Enemy("ogre", new Coordinates(14,10), new Statistics(1, 0, 5, 5, 5, 5, 10, 5), "\ud83d\udc79");
        Enemy ghost = new Enemy("ghost", new Coordinates(26,8), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc7b");
        
        enemys.add(bandit);
        enemys.add(ogre);
        enemys.add(ghost);

    }

    public List<Enemy> getEnemyList(){
        return enemys;
    }
}

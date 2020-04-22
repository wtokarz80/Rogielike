import java.util.ArrayList;
import java.util.List;

public class EnemyList {
    private List<Enemy> enemys = new ArrayList<>();

    EnemyList(){
        createEnemys();
    }

    private void createEnemys(){


        Enemy bandit = new Enemy("bandit", new Coordinates(14,5), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc7a");
        enemys.add(bandit);
    }

    public List<Enemy> getEnemyList(){
        return enemys;
    }
}

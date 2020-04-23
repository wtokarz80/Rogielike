import java.util.ArrayList;
import java.util.List;

public class EnemyList {
    private List<Enemy> enemys = new ArrayList<>();
    private List<Enemy> enemys2 = new ArrayList<>();

    EnemyList(){
        createEnemys();
    }

    private void createEnemys(){


        Enemy bandit = new Enemy("bandit", new Coordinates(14,5), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc7a");
        Enemy ogre = new Enemy("ogre", new Coordinates(14,10), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd8d");
        Enemy ghost = new Enemy("ghost", new Coordinates(26,8), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc7b");


        enemys.add(bandit);
        enemys.add(ogre);
        enemys.add(ghost);


        Enemy crab = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab2 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab3 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab4 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab5 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab6 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab7 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab8 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy crab9 = new Enemy("crab", new Coordinates(Common.randInt(),Common.randInt()), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83e\udd80");
        Enemy diablo = new Enemy("diablo", new Coordinates(14,19), new Statistics(1, 0, 5, 5, 5, 5, 5, 5), "\ud83d\udc79");




        enemys2.add(crab);
        enemys2.add(crab2);
        enemys2.add(crab3);
        enemys2.add(crab4);
        enemys2.add(crab5);
        enemys2.add(crab6);
        enemys2.add(crab7);
        enemys2.add(crab8);
        enemys2.add(crab9);
        enemys2.add(diablo);


        


    }

    public List<Enemy> getEnemyList(){
        return enemys;
    }

    public List<Enemy> getEnemyList2(){
        return enemys2;
    }
}

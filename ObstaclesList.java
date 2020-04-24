import java.util.ArrayList;
import java.util.List;

public class ObstaclesList {
    private List<Obstacle> obstacles = new ArrayList<>();
    private List<Obstacle> obstacles2 = new ArrayList<>();

    ObstaclesList(){
        createObstacles();
    }

    private void createObstacles(){
        int width = 30;
        int height = 30;

        Obstacle wall1 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(0, 0), width, 1);
        Obstacle wall2 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(0, 0), 1, height);
        Obstacle wall3 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(width-1, 0), width, 1);
        Obstacle wall4 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(0, height-1), 1, height-1);
        Obstacle wall5 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(1, 25), 1, 10);
        Obstacle wall6 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(10, 27), 2, 1);
        Obstacle wall7 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(6, 1), 20, 1);
        Obstacle wall8 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(6, 20), 1, 18);
        Obstacle wall9 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(24, 7), 14, 1);
        Obstacle wall10 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(11, 7), 1, 13);
        Obstacle treeKey = new Obstacle("wall", "\ud83c\udf32", new Coordinates(21, 17), 1, 3);
        Obstacle treeKey2 = new Obstacle("wall", "\ud83c\udf32", new Coordinates(21, 19), 1, 1);
        Obstacle tree = new Obstacle ("tree", "\ud83c\udf32", new Coordinates(8, 3), 1, 1);
        Obstacle tree1 = new Obstacle ("tree", "\ud83c\udf32", new Coordinates(2, 5), 2, 2);
        Obstacle tree2 = new Obstacle ("tree", "\ud83c\udf32", new Coordinates(25, 24), 4, 3);
        Obstacle tree3 = new Obstacle ("tree", "\ud83c\udf32", new Coordinates(9, 13), 1, 2);
        Obstacle door = new Obstacle("door", "\ud83d\udeaa", new Coordinates(10, 26), 1, 1);
        Obstacle hause = new Obstacle("hause", "\ud83c\udfe0", new Coordinates(3, 2), 1, 1);
        Obstacle boss = new Obstacle("boss", "\ud83e\uddd9", new Coordinates(21, 18), 1, 1);

        



        Obstacle wall25 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(1, 16), 1, 3);
        Obstacle wall26 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(5, 16), 1, 25);
        Obstacle wall27 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(15, 1), 4, 1);
        Obstacle wall28 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(15, 20), 10, 1);
        Obstacle wall29 = new Obstacle("wall", "\ud83e\uddf1", new Coordinates(15, 6), 13, 1);
        Obstacle toilet = new Obstacle("toilet", "\ud83d\udebd", new Coordinates(19, 15), 1, 1);
        Obstacle bed = new Obstacle("bed", "\ud83d\udecf\ufe0f ", new Coordinates(28, 26), 1, 1);
        Obstacle couch = new Obstacle("couch", "\ud83d\udecb\ufe0f ", new Coordinates(2, 25), 1, 1);
        Obstacle lady = new Obstacle("lady", "\ud83d\udc83", new Coordinates(24, 22), 1, 1);


        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        this.obstacles.add(wall3);
        this.obstacles.add(wall4);
        this.obstacles.add(wall5);
        this.obstacles.add(wall6);
        this.obstacles.add(wall7);
        this.obstacles.add(wall8);
        this.obstacles.add(wall9);
        this.obstacles.add(wall10);
        this.obstacles.add(treeKey);
        this.obstacles.add(treeKey2);      
        this.obstacles.add(tree);
        this.obstacles.add(tree1);
        this.obstacles.add(tree2);
        this.obstacles.add(tree3);
        this.obstacles.add(door);
        this.obstacles.add(hause);

        this.obstacles2.add(wall25);
        this.obstacles2.add(wall26);
        this.obstacles2.add(wall27);
        this.obstacles2.add(wall28);
        this.obstacles2.add(wall29);
        this.obstacles2.add(toilet);
        this.obstacles2.add(wall1);
        this.obstacles2.add(wall2);
        this.obstacles2.add(wall3);
        this.obstacles2.add(wall4);
        this.obstacles2.add(bed);
        this.obstacles2.add(couch);
        this.obstacles2.add(lady);
        this.obstacles.add(boss);
    


    }

    public List<Obstacle> getObstacles(){
        return obstacles;
    }

    public List<Obstacle> getObstacles2(){
        return obstacles2;
    }

}
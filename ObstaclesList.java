import java.util.ArrayList;
import java.util.List;

public class ObstaclesList {
    private List<Obstacle> obstacles = new ArrayList<>();

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
    


    }

    public List<Obstacle> getObstacles(){
        return obstacles;
    }

}
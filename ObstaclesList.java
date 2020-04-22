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
        Obstacle tree = new Tree ("tree", "\ud83c\udf32", new Coordinates(7, 8), 1, 1);

        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        this.obstacles.add(wall3);
        this.obstacles.add(wall4);
        this.obstacles.add(tree);

    }

    public List<Obstacle> getObstacles(){
        return obstacles;
    }

}
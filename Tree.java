
public class Tree extends Obstacle{

    private String name;

    public Tree(Coordinates pivot, int width, int height, String symbol, String name) {
        super(pivot, width, height, symbol);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    



}
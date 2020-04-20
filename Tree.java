
public class Tree extends Obstacle{

    private String name;

    public Tree(Coordinates pivot, int width, int height, String symbol, String name) {
        super(pivot, width, height, symbol);
        this.name = "Tree";
        // super.symbol = "\ud83c\udf32";
    }

    public String getName() {
        return name;
    }

    



}
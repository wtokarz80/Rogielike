
public class Tree extends Obstacle{

    public Tree(String name, String symbol, Coordinates pivot, int width, int height) {
        super(name, symbol, pivot, width, height);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void use(Player player) {
        player.setSymbol("\ud83c\udf2d");

    }

    



}
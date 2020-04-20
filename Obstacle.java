
public class Obstacle {
    Coordinates pivot;
    int width;
    int height;
    String symbol;

    public Obstacle(Coordinates pivot, int width, int height, String symbol){
        this.pivot = pivot;
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    public Coordinates getPivot(){
        return pivot;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getSymbol(){
        return symbol;
    }

    public void use(Player player){
        
    }



}

public abstract class GameObject {

    protected String name;
    private String symbol;
    private Coordinates pivot;
    private int width;
    private int height;

    public GameObject(String name, String symbol, Coordinates pivot, int width, int height){
        this.symbol = symbol;
        this.name = name;
        this.pivot = pivot;
        this.width = width;
        this.height = height;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getPivot() {
        return pivot;
    }

    public void setPivot (Coordinates pivot) {
        this.pivot = pivot;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void use(Player player);

}

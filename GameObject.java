
public abstract class GameObject {

    protected Coordinates coord;
    protected String name;
    protected String symbol;

    public GameObject(String name, String symbol, Coordinates coord){
        this.name = name;
        this.symbol = symbol;
        this.coord = coord;
    }



    public abstract String getSymbol();

    public abstract void setSymbol(String symbol);

    public abstract String getName();

    public abstract void setCoord (Coordinates coord);

    public abstract void setName(String name);

    public abstract Coordinates getCoord();

    public abstract void use(Player player);

}

public class Key extends GameObject{
    private String symbol;
    private Coordinates pivot;
    private int width;
    private int height;

    public Key(String name, String symbol, Coordinates pivot, int width, int height) {
        super(name, symbol, pivot, width, height);
        this.name = name;
        this.symbol = symbol;
        this.pivot = pivot;
        this.width = width;
        this.height = height;

    }

    public String getSymbol(){
        return this.symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setPivot (Coordinates pivot){
        this.pivot = pivot;
    }

    public void setName(String name){
        this.name = name;
    }

    public Coordinates getPivot(){
        return this.pivot;
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

    public void use(Player player){
        setPivot(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");
        player.addItem("key");
    }
        
    }

    



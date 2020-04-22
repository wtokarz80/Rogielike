
public abstract class Character {
    private String name;
    private Coordinates coord;
    private Statistics stats;
    private String symbol;

    public Character(String name, Coordinates coord, Statistics stats, String symbol){
        this.name = name;
        this.coord = coord;
        this.stats = stats;
        this.symbol = symbol;
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public void setCoordinates(Coordinates coord){
        this.coord = coord;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public Statistics getStats(){
        return stats;
    }

    public void setStats(Statistics stats){
        this.stats = stats;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void use(Player player);
    
}
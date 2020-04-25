import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private boolean isAlive;
    private Coordinates coord;
    private Statistics stats;
    private String symbol;
    private Map<String, Integer> inventory;

    public Player(String name, Coordinates coord, Statistics stats, String symbol) {
        this.name = name;
        this.symbol = symbol;
        this.coord = coord;
        this.stats = stats;
        this.inventory = new HashMap<>();
        this.isAlive = true;

    }

    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        this.coord = new Coordinates(x, y);
    }


    public void addItem(String item) {
        Integer count = inventory.get(item);
        if (count == null) {
            inventory.put(item, 1);
        } else {
            inventory.put(item, count + 1);
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
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

    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }
    
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
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

}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private Coordinates coord;
    private Statistics stats;
    private String symbol;
    // private String symbol = "\ud83d\udd7a";
    private Map<String, Integer> inventory;

    public Player(String name, Coordinates coord, Statistics stats, String symbol) {
        this.name = name;
        this.symbol = symbol;
        this.coord = coord;
        this.stats = stats;
        // this.coord = new Coordinates(5,5);
        // this.stats = new Statistics(1,0,10,10,10, 5, 5, 5);
        this.inventory = new HashMap<>();

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
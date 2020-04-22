
public class Player {
    Coordinates coord;
    Statistics stats;
    String symbol = "\ud83d\udd7a";

    public Player() {
        this.coord = new Coordinates(5,5);
        this.stats = new Statistics(1,0,10,10,10,1,1,1);
    }

    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();

        this.coord = new Coordinates(x, y);
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
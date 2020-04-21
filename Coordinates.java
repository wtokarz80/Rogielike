
public class Coordinates {
    public static final Coordinates W = new Coordinates(-1, 0);
    public static final Coordinates S = new Coordinates(1, 0);
    public static final Coordinates A = new Coordinates(0, -1);
    public static final Coordinates D = new Coordinates(0, 1);
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "x: " + this.x + " y: " + this.y;
    }
}


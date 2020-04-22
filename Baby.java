
public class Baby extends Player {

    private String symbol = "\ud83d\udc83";
    private Coordinates coord = new Coordinates(5, 27);
    private boolean isTouchingHer = false;

    public Baby(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }


    public void move(Coordinates direction, Player player, Baby baby) {
        TouchHer(player, baby);
        if (isTouchingHer){
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        this.coord = new Coordinates(x, y);}
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setCoords(Coordinates newCoordinates){
        this.coord = newCoordinates;
    }
    public Coordinates getCoord(){
        return coord;
    }

    private void TouchHer(Player player, Baby baby){
        if (player.getCoord().getX()==baby.getCoord().getX() && player.getCoord().getY()==baby.getCoord().getY()){
            this.isTouchingHer = true;
    }

}
}

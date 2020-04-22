
public class Baby extends Player {

     private String symbol;
     private Coordinates coord ;
   //  private Statistics stats;
   // private String name;
     private boolean isTouchingHer = false;

    public Baby(String name, Coordinates coord, Statistics stats, String symbol) {
        super(name, coord, stats, symbol);
     //   this.name = name;
        this.coord = coord;
   //     this.stats = stats;
        this.symbol = symbol;
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

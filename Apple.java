

public class Apple extends GameObject{
    private Coordinates coord;
    private String symbol = "\uD83C\uDF4E";


    public Apple(Coordinates a){
        this.coord = a;
    }

	public String getSymbol(){
        return this.symbol;
    }
    
    public Coordinates getCoordinates(){
        return this.coord;
    }

  //  public void use();
}
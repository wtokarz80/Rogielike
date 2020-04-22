
public class Obstacle extends GameObject{

    public Obstacle(String name, String symbol, Coordinates pivot, int width, int height) {
        super(name, symbol, pivot, width, height);
        
    }

    @Override
    public void use(Player player) {
        if (super.getName().equals("tree")){
            player.setSymbol("\ud83c\udf2d");
        }
        else if (super.getName().equals("door")) {
            if (player.getInventory().containsKey("key") == false){
                System.out.println("You need a key.");
            }
            else{
                super.setPivot(new Coordinates(0, 0));
                super.setSymbol("\ud83e\uddf1");
            }
        }

    }


}
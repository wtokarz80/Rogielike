public class Item extends GameObject{
 

    public Item(String name, String symbol, Coordinates pivot, int width, int height) {
        super(name, symbol, pivot, width, height);

    }


    public void use(Player player){
        player.addItem(name);
        setPivot(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");
    }
        
    }

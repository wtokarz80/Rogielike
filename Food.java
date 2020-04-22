public class Food extends GameObject{

    private int increaseHP;

    public Food(String name, String symbol, Coordinates pivot, int width, int height, int increaseHP) {
        super(name, symbol, pivot, width, height);
        this.increaseHP = increaseHP;
    }


    public void use(Player player){
        setPivot(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");
        int playerHP = player.getStats().getCurrentHP() + increaseHP;
        player.getStats().setCurrentHP(playerHP);
    }
        
    }

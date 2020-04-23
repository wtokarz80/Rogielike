
public class Enemy extends Character {

    public Enemy(String name, Coordinates coord, Statistics stats, String symbol) {
        super(name, coord, stats, symbol);
        
        
    }

    @Override
    public void use(Player player) {
        if (super.getName().equals("bandit")){
            int newHP = player.getStats().getCurrentHP() - 2;
            int newExp = player.getStats().getExp() + 2;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);   
            setCoordinates(new Coordinates(0, 0));
            setSymbol("\ud83e\uddf1 ");         
        }
        if (super.getName().equals("crab")){
            int newHP = player.getStats().getCurrentHP() - 1;
            int newExp = player.getStats().getExp() + 1;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);   
            setCoordinates(new Coordinates(0, 0));
            setSymbol("\ud83e\uddf1 ");         
        }
        if (super.getName().equals("diablo")){
            int newHP = player.getStats().getCurrentHP() - 5;
            int newExp = player.getStats().getExp() + 10;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);   
            setCoordinates(new Coordinates(0, 0));
            setSymbol("\ud83e\uddf1 ");         
        }
    }
}
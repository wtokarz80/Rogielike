
public class Obstacle extends GameObject {

    public Obstacle(String name, String symbol, Coordinates pivot, int width, int height) {
        super(name, symbol, pivot, width, height);

    }

    @Override
    public void use(Player player) {
        // if (super.getName().equals("tree")){
        // player.setSymbol("\ud83c\udf2d");
        // }
        // else if (super.getName().equals("door")) {
        // if (player.getInventory().containsKey("key") == false){
        // System.out.println("You need a key.");
        // }
        // else{
        // super.setPivot(new Coordinates(0, 0));
        // super.setSymbol("\ud83e\uddf1");
        // }
        // }

        switch (super.getName()) {
            case "door":
                doorAction(player);
                break;
            // case "ghost":
            // ghostFight(player);
            // break;
            case "boss":
                bossAction(player);
                break;
        }
    }

    private void doorAction(Player player) {
        if (player.getInventory().containsKey("key") == false) {
            System.out.println("You need a key.");
        } else {
            super.setPivot(new Coordinates(0, 0));
            super.setSymbol("\ud83e\uddf1");
        }
    }

    public void bossAction(Player player) {
        if (player.getStats().getLvl() >= 2) {
            
            int newHP = player.getStats().getCurrentHP() - 7;
            int newExp = player.getStats().getExp() + 7;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);
            super.setPivot(new Coordinates(0, 0));
            super.setSymbol("\ud83e\uddf1");

        } else if (player.getStats().getCurrentHP() <= 0) {
            player.setIsAlive(false);
        } else {
            System.out.println("Your level is to low to fight me");
        }

    }

}
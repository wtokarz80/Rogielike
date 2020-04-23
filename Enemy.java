
public class Enemy extends Character {

    public Enemy(String name, Coordinates coord, Statistics stats, String symbol) {
        super(name, coord, stats, symbol);

    }

    @Override
    public void use(Player player) {

        switch (super.getName()) {
            case "bandit":
                banditFight(player);
                break;
            case "ogre":
                ogreFight(player);
                break;
            case "ghost":
                ghostFight(player);
                break;
        }
    }

    public void banditFight(Player player) {
        int newHP = player.getStats().getCurrentHP() - 2;
        int newExp = player.getStats().getExp() + 2;
        player.getStats().setCurrentHP(newHP);
        player.getStats().setExp(newExp);
        if (player.getStats().getExp() >= 10) {
            player.getStats().setLvl(2);
        } else if (player.getStats().getCurrentHP() <= 0) {
            player.setIsAlive(false);
        }
        setCoordinates(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");

    }

    public void ogreFight(Player player) {
        int newHP = player.getStats().getCurrentHP() - 5;
        int newExp = player.getStats().getExp() + 5;
        player.getStats().setCurrentHP(newHP);
        player.getStats().setExp(newExp);
        if (player.getStats().getExp() >= 10) {
            player.getStats().setLvl(2);
        } else if (player.getStats().getCurrentHP() <= 0) {
            player.setIsAlive(false);
        }
        setCoordinates(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");

    }

    public void ghostFight(Player player) {
        int newHP = player.getStats().getCurrentHP() - 3;
        int newExp = player.getStats().getExp() + 3;
        player.getStats().setCurrentHP(newHP);
        player.getStats().setExp(newExp);
        if (player.getStats().getExp() >= 10) {
            player.getStats().setLvl(2);
        } else if (player.getStats().getCurrentHP() <= 0) {
            player.setIsAlive(false);
        }
        setCoordinates(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1 ");

    }

}
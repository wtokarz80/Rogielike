import java.util.Scanner;

public class Enemy extends Character {
    public Scanner action = new Scanner(System.in);

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
            case "crab":
                crabFight(player);
                break;
            case "diablo":
                diabloFight(player);
                break;
        }
    }

    public void banditFight(Player player) {
        Statistics bandit = new Statistics(1, 0, 5, 5, 5, 3, 6, 2);
        int bonusDef = 0;
        System.out.println("\nWild bandit appeard !\n");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + bandit.currentHP + "/" + bandit.maxHP);
            System.out.println("\nWhat you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("\nYou attacked for: " + (player.getStats().attack - bandit.def) + "damage");
                    bandit.currentHP -= player.getStats().attack - bandit.def;
                    if (bandit.currentHP <= 0) {
                        System.out.println("\nYou defeated bandit");
                        setCoordinates(new Coordinates(0, 0));
                        setSymbol("\ud83e\uddf1 ");
                        player.getStats().exp += 3;
                        if (player.getStats().getExp() >= 10) {
                            player.getStats().setLvl(2);
                        }
                        fight = false;
                        break;
                    }
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                }
                    break;

                case "2":
                    player.getStats().def += 1;
                    bonusDef += 1;
                    player.getStats().currentHP -= bandit.attack - player.getStats().def;
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        fight = false;
                        break;
                    }
                }
                    break;
                case "3":
                    String[] escape = { "Escaped", "Escaped", "Escaped", "Failed" };
                    String result = escape[(int) (Math.random() * escape.length)];
                    if (result == "Escaped") {
                        System.out.println("\nYou escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("\nYou failed to escape");
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                }
            }
            player.getStats().def -= bonusDef;

        }
        }
        public void crabFight(Player player) {
            int newHP = player.getStats().getCurrentHP() - 1;
            int newExp = player.getStats().getExp() + 1;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);   
            setCoordinates(new Coordinates(0, 0));
            setSymbol("\ud83e\uddf1 ");         
        }


        public void diabloFight(Player player) {
            int newHP = player.getStats().getCurrentHP() - 5;
            int newExp = player.getStats().getExp() + 10;
            player.getStats().setCurrentHP(newHP);
            player.getStats().setExp(newExp);   
            setCoordinates(new Coordinates(0, 0));
            setSymbol("\ud83e\uddf1 ");         
        }
        
    

    public void ghostFight(Player player) {
        Statistics ghost = new Statistics(1, 0, 5, 5, 5, 4, 6, 4);
        int bonusDef = 0;
        System.out.println("\nWild ghost appeard !\n");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + ghost.currentHP + "/" + ghost.maxHP);
            System.out.println("\nWhat you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("\nYou attacked for: " + (player.getStats().attack - ghost.def) + "damage");
                    ghost.currentHP -= player.getStats().attack - ghost.def;
                    if (ghost.currentHP <= 0) {
                        System.out.println("\nYou defeated ghost");
                        setCoordinates(new Coordinates(0, 0));
                        setSymbol("\ud83e\uddf1 ");
                        player.getStats().exp += 3;
                        if (player.getStats().getExp() >= 10) {
                            player.getStats().setLvl(2);
                        }
                        fight = false;
                        break;
                    }
                    if (ghost.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ghost.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                        }
                    }
                    break;

                case "2":
                    player.getStats().def += 1;
                    bonusDef += 1;
                    if (ghost.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ghost.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                }
                    break;
                case "3":
                    String[] escape = { "Escaped", "Escaped", "Escaped", "Failed" };
                    String result = escape[(int) (Math.random() * escape.length)];
                    if (result == "Escaped") {
                        System.out.println("\nYou escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("\nYou failed to escape");
                    if (ghost.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ghost.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                    break;
            }
            break;
        }
    }
        player.getStats().def -= bonusDef;
    }
    

    public void ogreFight(Player player) {
        Statistics ogre = new Statistics(1, 0, 5, 5, 5, 4, 6, 4);
        int bonusDef = 0;
        System.out.println("Wild Ogre appeard !");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + ogre.currentHP + "/" + ogre.maxHP);
            System.out.println("What you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("\nYou attacked for: " + (player.getStats().attack - ogre.def) + "damage");
                    ogre.currentHP -= player.getStats().attack - ogre.def;
                    if (ogre.currentHP <= 0) {
                        System.out.println("\nYou defeated ogre");
                        setCoordinates(new Coordinates(0, 0));
                        setSymbol("\ud83e\uddf1 ");
                        player.getStats().exp += 4;
                        if (player.getStats().getExp() >= 10) {
                            player.getStats().setLvl(2);
                        }
                        fight = false;
                        break;
                    }
                    if (ogre.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ogre.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                }
                break;
                case "2":
                    player.getStats().def += 1;
                    bonusDef += 1;
                    if (ogre.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ogre.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                            System.out.println("You died");
                            fight = false;
                            break;
                        }
                    }
                    break;
                case "3":

                    String[] escape = { "Escaped", "Escaped", "Escaped", "Failed" };
                    String result = escape[(int) (Math.random() * escape.length)];
                    if (result == "Escaped") {
                        System.out.println("\nYou escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("\nYou failed to escape");
                    if (ogre.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ogre.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("\nYou died");
                        fight = false;
                        break;
                    }
                    break;
                }
            }
        }
        player.getStats().def -= bonusDef;
    }
}

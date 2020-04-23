import java.util.Scanner;
import java.util.Random;

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
        Statistics bandit = new Statistics(1, 0, 5, 5, 5, 5, 10, 5);
        int bonusDef = 0;
        System.out.println("Wild bandit appeard !");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + bandit.currentHP + "/" + bandit.maxHP);
            System.out.println("What you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            Scanner action = new Scanner(System.in);
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("You attacked for: " + (player.getStats().attack - bandit.def) + "damage");
                    bandit.currentHP -= player.getStats().attack - bandit.def;
                    if (bandit.currentHP <= 0) {
                        System.out.println("You defeated bandit");
                        player.getStats().exp += 3;
                        fight = false;
                        break;
                    }
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
                }
                break;

                case "2":
                    player.getStats().def += 1;
                    bonusDef += 1;
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
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
                        System.out.println("You escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("You failed to escape");
                    if (bandit.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= bandit.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
            }
            break;
        }
        player.getStats().def -= bonusDef;
    }
}

    public void ghostFight(Player player) {
        Statistics ghost = new Statistics(1, 0, 5, 5, 5, 5, 10, 5);
        int bonusDef = 0;
        System.out.println("Wild ghost appeard !");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + ghost.currentHP + "/" + ghost.maxHP);
            System.out.println("What you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            Scanner action = new Scanner(System.in);
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("You attacked for: " + (player.getStats().attack - ghost.def) + "damage");
                    ghost.currentHP -= player.getStats().attack - ghost.def;
                    if (ghost.currentHP <= 0) {
                        System.out.println("You defeated ghost");
                        player.getStats().exp += 3;
                        fight = false;
                        break;
                    }
                    if (ghost.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ghost.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
                }
                break;

                case "2":
                    player.getStats().def += 1;
                    bonusDef += 1;
                    player.getStats().currentHP -= ghost.attack - player.getStats().def;
                    if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
                    break;
                case "3":
                    String[] escape = { "Escaped", "Escaped", "Escaped", "Failed" };
                    String result = escape[(int) (Math.random() * escape.length)];
                    if (result == "Escaped") {
                        System.out.println("You escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("You failed to escape");
                    if (ghost.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ghost.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                            System.out.println("You died");
                            fight = false;
                            break;
                        }
                    }
                    break;

            }
        }
        player.getStats().def -= bonusDef;
    }

    public void ogreFight(Player player) {
        Statistics ogre = new Statistics(1, 0, 5, 5, 5, 5, 10, 5);
        int bonusDef = 0;
        System.out.println("Wild Ogre appeard !");
        boolean fight = true;
        while (fight == true) {
            System.out.println("Your Hp: " + player.getStats().currentHP + "/ " + player.getStats().maxHP);
            System.out.println("Enemy hp: " + ogre.currentHP + "/" + ogre.maxHP);
            System.out.println("What you want to do ? \n1.Attack \n" + "2.Defence \n3.Try to escape");
            Scanner action = new Scanner(System.in);
            String actions = action.nextLine();

            switch (actions) {
                case "1":
                    System.out.println("You attacked for: " + (player.getStats().attack - ogre.def) + "damage");
                    ogre.currentHP -= player.getStats().attack - ogre.def;
                    if (ogre.currentHP <= 0) {
                        System.out.println("You defeated ogre");
                        player.getStats().exp += 3;
                        fight = false;
                        break;
                    }
                    if (ogre.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ogre.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
                    break;
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
                        System.out.println("You escaped!");
                        fight = false;
                        break;
                    }
                    System.out.println("You failed to escape");
                    if (ogre.attack - player.getStats().def >= 0) {
                        player.getStats().currentHP -= ogre.attack - player.getStats().def;
                        if (player.getStats().currentHP <= 0) {
                        System.out.println("You died");
                        fight = false;
                        break;
                    }
                }
                break;
            }
        }
        player.getStats().def -= bonusDef;
    }
}

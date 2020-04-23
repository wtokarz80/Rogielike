import java.util.Scanner;

public class Common {

    public static Scanner scan = new Scanner(System.in);


    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void displayStats(Player player) {
        String title = String.format(
                "\nPlayer %s stats: \n" + "LEVEL: %d\n" + "HP: %d\n" + "STR = %d\n" + "ATTACK = %d\n" + "DEF = %d\n"
                        + "EXP = %d / %d",
                player.getName(), player.getStats().getLvl(), player.getStats().getCurrentHP(),
                player.getStats().getStr(), player.getStats().getAttack(), player.getStats().getDef(),
                player.getStats().getExp(), player.getStats().getExpToLvl());
        System.out.println(title);
    }

    public static void displayInventory(Player player){
        System.out.println("Your inventory:");
        for (String key : player.getInventory().keySet()) {
            System.out.print(key + ": " + player.getInventory().get(key) + " ");
        }
    }

    public static String gatherName(String title){
        System.out.print(title);
        scan.useDelimiter(System.lineSeparator());
        String stringInput = "";
        stringInput = scan.next();
        if (stringInput.length() > 10){
            stringInput = stringInput.substring(0, 10);
        }
        return stringInput;
    }

    public static Player createPlayer(Player player){
        String name = gatherName("Enter your name hero: ");
        // int points = 15;
        // String[] stringStats = {"str", "attack", "def"};
        int[] intStats = {5, 5, 5};
        // for (int i = 0; i < stringStats.length; i++){
        //     System.out.println("You have " + points + " points");
        //     System.out.printf("Set your %s: ", stringStats[i]);
        //     intStats[i] = scan.nextInt();
        //     points = points - intStats[i];
        // }
        player = new Player(name, new Coordinates(2,2), new Statistics(1,0,10,10,10, intStats[0], intStats[1], intStats[2]), "\ud83d\udd7a");
        return player;
        
    }
}
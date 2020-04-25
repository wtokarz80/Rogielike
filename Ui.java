import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ui {

    public static Scanner scan = new Scanner(System.in);

    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gameMenu() throws IOException {
        boolean keepGoing = true;
        while (keepGoing){
            clearScreen();
            printMenu();
            int userOption = gatherIntInput("Enter option: ", 3);
            clearScreen();
            switch(userOption){
                case 1:
                    game();
                    keepGoing = false;
                    break;
                case 2:
                    printIntroduction();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        
    }

    private void game() throws IOException {
        Game game = new Game();
        JTextField textField = new JTextField();
        textField.addKeyListener(game);
        JFrame jframe = new JFrame();
        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);

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
        int[] intStats = {5, 5, 5};
        player = new Player(name, new Coordinates(2,2), new Statistics(1,0,10,10,10, intStats[0], intStats[1], intStats[2]), "\ud83d\udd7a");
        return player;
        
    }

    public static void printIntroduction(){
        clearScreen();
        System.out.println("                              RESCUE 2               ");
        String introduction =  "\n    Welcome HERO. Have you always dreamt of fame, power and waelth?\n"
                           + "Nothing simpler. Release the proncess kidnapped by the evil sorcerer\n"
                           + "and bring her to the castle, than your dreams will come true.\n"
                           + "LET'S GO!. \n\n";
        System.out.println(introduction);
        emptyInput();
    }

    public static void emptyInput(){
        scan.useDelimiter(System.lineSeparator());
        System.out.println("\nPress enter...");
        scan.next();
        clearScreen();
    }

    public int gatherIntInput(String title, int numberOfOptions){
        scan.useDelimiter(System.lineSeparator());
        int option = 0;
        String userInput;
        System.out.print(title);
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("")){
                if(userInput.matches("^[0-9]*$")){
                    option = Integer.parseInt(userInput);
                    if(option >= 0 && option < numberOfOptions){
                        validInput = true;
                    }
                }
            }
            
        }
        return option;
    }

    public String gatherStringInput(String title){
        System.out.print(title);
        scan.useDelimiter(System.lineSeparator());
        String stringInput = "";
        stringInput = scan.nextLine();
        if (stringInput.length() > 10){
            stringInput = stringInput.substring(0, 10);
        }
        return stringInput;
    }

    private void printMenu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                         + "|          RESCUE 2        |\n"
                         + "|--------------------------|\n"
                         + "| 1 - Start game           |\n"
                         + "| 2 - Show introduction    |\n"
                         + "| 0 - Exit game            |\n"
                          + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }


    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static Integer randInt(){
        Random rand = new Random();
        return rand.nextInt(26) + 2;
        
    }
}


import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
        while (keepGoing) {
            clearScreen();
            printMenu();
            int userOption = gatherIntInput("Enter option: ", 3);
            clearScreen();
            switch (userOption) {
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

    }

    public static void displayInventory(Player player) {
        System.out.println("Your inventory:");
        for (String key : player.getInventory().keySet()) {
            System.out.print(key + ": " + player.getInventory().get(key) + " ");
        }
    }

    public static String gatherName(String title) {
        System.out.print(title);
        scan.useDelimiter(System.lineSeparator());
        String stringInput = "";
        stringInput = scan.next();
        if (stringInput.length() > 10) {
            stringInput = stringInput.substring(0, 10);
        }
        return stringInput;
    }

    public static Player createPlayer(Player player) {
        String name = gatherName("Enter your name hero: ");
        int[] intStats = {5, 5, 5};
        player = new Player(name, new Coordinates(2, 2),
                new Statistics(1, 0, 10, 10, 10, intStats[0], intStats[1], intStats[2]), "\ud83d\udd7a");
        return player;

    }

    public static void printIntroduction() {
        clearScreen();
        try {
            File myObj = new File("intro.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String intro = myReader.nextLine();
                System.out.println(intro);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        emptyInput();
    }

    public static void emptyInput() {
        scan.useDelimiter(System.lineSeparator());
        System.out.println("\nPress enter...");
        scan.next();
        clearScreen();
    }

    public int gatherIntInput(String title, int numberOfOptions) {
        scan.useDelimiter(System.lineSeparator());
        String userInput = "";
        System.out.print(title);
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (isNumericValue(userInput) && isNumberInRange(userInput, numberOfOptions)) {
                validInput = true;
            }
        }
        return Integer.parseInt(userInput);
    }

    private boolean isNumericValue(String userInput) {
        return !userInput.equals("") && userInput.matches("^[0-9]*$");
    }

    private boolean isNumberInRange(String userInput, int numberOfOptions) {
        int option = Integer.parseInt(userInput);
        return option >= 0 && option < numberOfOptions;
    }

    public String gatherStringInput(String title) {
        System.out.print(title);
        scan.useDelimiter(System.lineSeparator());
        String stringInput = "";
        stringInput = scan.nextLine();
        if (stringInput.length() > 10) {
            stringInput = stringInput.substring(0, 10);
        }
        return stringInput;
    }

    private void printMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + "|          RESCUE 2        |\n"
                + "|--------------------------|\n" + "| 1 - Start game           |\n" + "| 2 - Show introduction    |\n"
                + "| 0 - Exit game            |\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static Integer randInt() {
        Random rand = new Random();
        return rand.nextInt(26) + 2;

    }
}

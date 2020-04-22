
public class Common {

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
        for (String key : player.getInventory().keySet()){
            System.out.print(key + ": " + player.getInventory().get(key) + " ");
        }
    }
}
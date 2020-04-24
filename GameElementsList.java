import java.util.ArrayList;
import java.util.List;

public class GameElementsList {
    private List<GameObject> gameElements = new ArrayList<>();
    private List<GameObject> gameElements2 = new ArrayList<>();

    GameElementsList(){
        createGameElementsList();
    }

    private void createGameElementsList(){

        Item key = new Item("key", "\ud83d\udddd\ufe0f ", new Coordinates(23, 19), 1, 1);
        Food apple1 = new Food("apple", "\ud83c\udf4e", new Coordinates(11, 11), 1, 1, 2);
        Food apple2 = new Food("apple", "\ud83c\udf4e", new Coordinates(16, 13), 1, 1, 2);
        Food hotdog = new Food("apple", "\ud83c\udf2d", new Coordinates(23, 14), 1, 1, 5);
        Food hotdo2 = new Food("apple", "\ud83c\udf2d", new Coordinates(28, 28), 1, 1, 5);
        Item arkenstone = new Item("arkenstone", "\ud83d\udc8e", new Coordinates(20, 9), 1, 1);
        Weapon sword = new Weapon("sword", " \u2694\ufe0f", new Coordinates(9, 9), 1, 1, 3, 0, 5);
        Weapon shield = new Weapon("shield", " \ud83d\udee1\ufe0f", new Coordinates(19, 15), 1, 1, 2, 5, 2);
        Food hotdog3 = new Food("apple", "\ud83c\udf2d", new Coordinates(5, 5), 1, 1, 5);
        Food hotdog4 = new Food("apple", "\ud83c\udf2d", new Coordinates(10, 6), 1, 1, 5);
        
        gameElements.add(key);
        gameElements.add(apple1);
        gameElements.add(apple2);
        gameElements.add(arkenstone);
        gameElements.add(sword);
        gameElements.add(shield);
        gameElements.add(hotdog);
        gameElements.add(hotdo2);
        gameElements2.add(hotdog3);
        gameElements2.add(hotdog4);
    }

    public List<GameObject> getGameElamenstList(){
        return gameElements;
    }
    public List<GameObject> getGameElamenstList2(){
        return gameElements2;
    }
}
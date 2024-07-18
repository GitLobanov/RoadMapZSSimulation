import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameMap {

    private HashMap<String,Entity> map = new HashMap<>();

    // |1|2|3|4|
    // |2| | | |

    public GameMap () {
        autoFill();
    }

    public void autoFill () {

        for (int i = 1; i <= 9; i++){
            for (int j = 0; j < 9; j++) {
                String place = String.valueOf(j).concat(String.valueOf(i));
                map.put(place, getRandomFill(place));
            }
        }
    }

    public void printMap () {
        clearScreen();

        System.out.println("_|1|2|3|4|5|6|7|8|9");

        for (int i = 1; i <= 9; i++){
            System.out.print(i);
            for (int j = 0; j < 9; j++) {
                System.out.print(map.get(String.valueOf(j).concat(String.valueOf(i))).icon);
            }
            System.out.println();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private Entity getRandomFill (String place) {
        Random r = new Random();
        List<Entity> randomEntity =
                List.of(new EmptyBlock(), new Predator(), new Grass(), new Herbivore(), new Rock(), new Tree());
        Entity entity = randomEntity.get(r.nextInt(0,randomEntity.size()-1));
        entity.setPlace(place);

        return entity;
    }

    public HashMap<String, Entity> getMap() {
        return map;
    }
}

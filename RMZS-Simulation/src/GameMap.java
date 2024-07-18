import java.util.List;
import java.util.Random;

public class GameMap {

    private MapClass mapClass = new MapClass(9,9);

    // |1|2|3|4|
    // |2| | | |

    public GameMap () {
        autoFill();
    }

    public void autoFill () {

        for (int i = 1; i <= mapClass.getCountRows(); i++){
            for (int j = 1; j <= mapClass.getCountColumns(); j++) {
                Cell cell = new Cell(j,i);
                mapClass.add(cell, getRandomFill(cell));
            }
        }
    }

    public void printMap () {
        clearScreen();

        System.out.println("_|1|2|3|4|5|6|7|8|9");

        for (Entity entity : mapClass.getEntities()) {
            System.out.print(entity.icon);
            if (entity.getPlaceInCell().getColumn() + 1 > 9) System.out.println();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private Entity getRandomFill (Cell cell) {
        Random r = new Random();
        List<Entity> randomEntity =
                List.of(new EmptyBlock(), new Predator(), new Grass(), new Herbivore(), new Rock(), new Tree());
        Entity entity = randomEntity.get(r.nextInt(0,randomEntity.size()-1));
        entity.setPlaceInCell(cell);

        return entity;
    }

    public MapClass getMapClass() {
        return mapClass;
    }
}

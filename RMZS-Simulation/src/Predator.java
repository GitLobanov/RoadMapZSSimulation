import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Predator extends Creature {

    private int powerOfAttack = 1;

    public Predator() {
        icon = "\uD83E\uDD96";
    }

    public void hitCreature(Creature creature) {
        creature.setHp(creature.getHp() - powerOfAttack);
    }

    @Override
    public void makeMove(HashMap<String, Entity> map) {

        int column = Integer.parseInt(getPlace().split("")[0]);
        int row = Integer.parseInt(getPlace().split("")[1]);

        int nextColumn = column + getSpeedInCell();
        int nextRow = row + getSpeedInCell();

        checkPlace(nextColumn, row, map);
        checkPlace(column, nextRow, map);
        checkPlace(nextColumn, nextRow, map);

        nextColumn = column - getSpeedInCell();
        nextRow = row - getSpeedInCell();

        checkPlace(nextColumn, row, map);
        checkPlace(column, nextRow, map);
        checkPlace(nextColumn, nextRow, map);
    }

    private void checkPlace(int next, int current, HashMap<String, Entity> map) {
        try {
            String key = next + "" + current;
            Herbivore herbivore = (Herbivore) map.get(key);
            hitCreature(herbivore);
            if (herbivore.getHp() < 1) {
                map.replace(key, new EmptyBlock());
            }
        } catch (Exception ignored) {
        }
    }
}

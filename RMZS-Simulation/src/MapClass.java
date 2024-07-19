import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

public class MapClass {

    private LinkedHashMap<Cell,Entity> map = new LinkedHashMap<>();
    private int columns;
    private int rows;

    public MapClass (int countColumn, int countRow) {
        columns = countColumn;
        rows = countRow;
    }

    public int getCountColumns() {
        return columns;
    }

    public int getCountRows() {
        return rows;
    }

    public Entity getEntity (Cell cell) {
        return map.get(cell);
    }

    public boolean contains (Cell cell){
        return map.containsKey(cell);
    }

    public void add (Cell cell, Entity entity) {
        map.put(cell,entity);
    }

    public void update(Cell cell, Entity entity) {
        add(cell, entity);
    }

    public void delete(Cell cell, Entity entity) {
        map.remove(cell, entity);
    }

    public Collection<Entity> getEntities() {
        return map.values();
    }
}

import java.util.HashMap;

public abstract class Creature extends Entity {

    private int speedInCell  = 1;
    private int hp;

    public int getSpeedInCell() {
        return speedInCell;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void makeMove(MapClass map);

    public boolean makeStep(MapClass mapClass) {

        for (Cell nearCell : getListNearCells()) {
            try {
                EmptyBlock emptyBlock = (EmptyBlock) mapClass.getEntity(nearCell);
                emptyBlock.setPlaceInCell(getPlaceInCell());
                mapClass.update(getPlaceInCell(), emptyBlock);

                mapClass.update(nearCell, this);
                setPlaceInCell(nearCell);
                return true;
            } catch (Exception ignored) {
            }
        }

        return false;

    }
}

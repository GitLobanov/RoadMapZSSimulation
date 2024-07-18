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

    public abstract void makeMove(HashMap<String, Entity> map);
}

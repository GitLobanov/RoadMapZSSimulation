import java.util.HashMap;

public class Herbivore extends Creature {

    public Herbivore () {
        icon = "\uD83D\uDC04";
    }

    @Override
    public void makeMove(MapClass mapClass) {
        boolean eat = eatPlant(mapClass);
        if (!eat) makeStep(mapClass);
    }

    private boolean eatPlant(MapClass mapClass) {

        for (Entity entity : mapClass.getEntities()) {

            for (Cell cell : getListNearCells()) {
                if (entity.getPlaceInCell().equals(cell)) {
                    try {
                        Grass grass = (Grass) entity;

                        EmptyBlock emptyBlock = new EmptyBlock();
                        emptyBlock.setPlaceInCell(cell);
                        mapClass.add(cell, emptyBlock);

                        return true;
                    } catch (Exception ignored) {

                    }

                }
            }

        }

        return false;
    }
}

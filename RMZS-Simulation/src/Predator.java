public class Predator extends Creature {

    private int powerOfAttack = 1;

    public Predator() {
        icon = "\uD83E\uDD96";
    }

    public void hitCreature(Creature creature) {
        creature.setHp(creature.getHp() - powerOfAttack);
    }

    @Override
    public void makeMove(MapClass mapClass) {

        boolean attack = attackHerbivore(mapClass);
        if (!attack) makeStep(mapClass);

    }

    private boolean makeStep(MapClass mapClass) {

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

    private boolean attackHerbivore(MapClass mapClass) {


        for (Entity entity : mapClass.getEntities()) {

            for (Cell cell : getListNearCells()) {
                if (entity.getPlaceInCell().equals(cell)) {
                    try {
                        Herbivore herbivore = (Herbivore) entity;
                        hitCreature(herbivore);

                        if (herbivore.getHp() <= 0) {
                            EmptyBlock emptyBlock = new EmptyBlock();
                            emptyBlock.setPlaceInCell(cell);
                            mapClass.add(cell, emptyBlock);
                        }

                        return true;
                    } catch (Exception ignored) {

                    }

                }
            }

        }

        return false;

    }
}

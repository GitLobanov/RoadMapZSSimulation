import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class Entity {
    protected String icon;
    private Cell placeInCell;
    private List <Cell> listNearCells;

    public Cell getPlaceInCell() {
        return placeInCell;
    }

    public void setPlaceInCell(Cell placeInCell) {
        this.placeInCell = placeInCell;

        listNearCells = new ArrayList<>();
        listNearCells.add(getLeftCell());
        listNearCells.add(getRightCell());
        listNearCells.add(getUpCell());
        listNearCells.add(getDownCell());
        Collections.shuffle(listNearCells);
    }

    public List <Cell> getListNearCells() {
        return listNearCells;
    }

    public Cell getLeftCell (){
        if (placeInCell.getColumn() - 1 > 0) return new Cell(placeInCell.getColumn() - 1, placeInCell.getRow());
        return new Cell(0,0);
    }

    public Cell getRightCell() {
        if (placeInCell.getColumn() + 1 < 10) return new Cell(placeInCell.getColumn() + 1, placeInCell.getRow());
        return new Cell(0,0);
    }

    public Cell getUpCell() {
        if (placeInCell.getRow() - 1 > 0) return new Cell(placeInCell.getColumn(), placeInCell.getRow() - 1);
        return new Cell(0,0);
    }

    public Cell getDownCell() {
        if (placeInCell.getRow() + 1 < 9) return new Cell(placeInCell.getColumn(), placeInCell.getRow() + 1);
        return new Cell(0,0);
    }
}

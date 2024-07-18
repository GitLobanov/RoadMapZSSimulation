import static java.lang.Thread.sleep;

public class Simulation {

    private static GameMap gameMap;
    private int countStep;

    public static void main(String[] args) {

        gameMap = new GameMap();

        gameMap.printMap();

        while (true) {
            startSimulation(gameMap);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void initActions () {

    }

    private void turnActions () {

    }


    private void nextTurn() {

    }

    private static void startSimulation(GameMap gameMap) {

        MapClass mapClass = gameMap.getMapClass();

        for (Entity entity : mapClass.getEntities()){
            try {
                Predator predator = (Predator) entity;
                predator.makeMove(mapClass);
            } catch (Exception ignored) {
            }
        }

        gameMap.printMap();

    }

    private void pauseSimulation() {

    }
}
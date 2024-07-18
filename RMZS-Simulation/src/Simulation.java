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
                sleep(7000);
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

        for (int i = 1; i <= 9; i++){

            for (int j = 0; j < 9; j++) {
                try {
                    Predator creature = (Predator) gameMap.getMap().get(String.valueOf(j).concat(String.valueOf(i)));
                    creature.makeMove(gameMap.getMap());
                } catch (Exception ignored) {
                }
            }
        }

        gameMap.printMap();

    }

    private void pauseSimulation() {

    }
}
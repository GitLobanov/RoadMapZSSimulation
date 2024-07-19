import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Simulation {

    private static DisplayMap displayMap;
    private static int countStep  = 0;

    public static void main(String[] args) {

        while (true) {
            userMenu();
        }

    }

    private void initActions () {
        // действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте


    }

    private void turnActions () {
        // действия, совершаемые каждый ход.
        // Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало


    }


    private void nextTurn() {

    }

    private static void startSimulation(DisplayMap displayMap) {

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            MapClass mapClass = displayMap.getMapClass();

            for (Entity entity : mapClass.getEntities()){
                try {
                    Creature creature = (Creature) entity;
                    creature.makeMove(mapClass);
                } catch (Exception ignored) {
                }
            }

            displayMap.printMap();
            countStep++;
            if (!haveHerbivore()) break;
        }

    }

    private void pauseSimulation() {

    }

    private static void userMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Хотите начать новую игру (н) или выйти (в) ?");
        String ans = input.nextLine();

        if (ans.equals("н")){
            displayMap = new DisplayMap();
            startSimulation(displayMap);
        } else if (ans.equals("в")) {
            System.exit(0);
        } else {
            System.out.println("Что?");
        }
    }

    private static boolean haveHerbivore () {
        MapClass mapClass = displayMap.getMapClass();

        for (Entity entity : mapClass.getEntities()){
            try {
                Herbivore creature = (Herbivore) entity;
                return mapClass.getEntities().contains(creature);
            } catch (Exception ignored) {
            }
        }

        System.out.println("Игра окончена, все травоядные погибли!");
        System.out.println("Сгенерировано ходов: [" + countStep + "]");
        return false;
    }
}
package org.example;

import org.example.enums.ObjectBehindDoor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    private static final int COUNT_OF_DOORS = 3;
    private static final int COUNT_OF_GAMES = 1000;
    private Random random = new Random();
    private boolean victory = false;
    private int indexChooseDoor;
    private int indexOpenDoor;
    private Door[] doors = new Door[COUNT_OF_DOORS];
    private int gameIndex = 0;
    private int countGamesWon = 0;
    private Map<Integer, String> totalResult = new HashMap<Integer, String>();

    private void createDoors() {
        for (int i = 0; i < COUNT_OF_DOORS; i++) {
            doors[i] = new Door();
        }
        doors[2].setObjectBehindDoor(ObjectBehindDoor.CAR);
    }

    private void chooseDoor() {
        indexChooseDoor = random.nextInt(COUNT_OF_DOORS);
    }

    private void reChooseDoor() {
        int tempIndex = random.nextInt(COUNT_OF_DOORS);
        if (tempIndex == indexChooseDoor || tempIndex == indexOpenDoor) {
            tempIndex = random.nextInt(COUNT_OF_DOORS);
        } else {
            indexChooseDoor = tempIndex;
        }
    }

    private void openFirstDoor() {
        int indexDoor = random.nextInt(COUNT_OF_DOORS);
        boolean flag = true;
            while (flag) {
                if (indexDoor == indexChooseDoor || doors[indexDoor].getObjectBehindDoor() == ObjectBehindDoor.CAR) {
                    indexDoor = random.nextInt(COUNT_OF_DOORS);
                } else {
                    indexOpenDoor = indexDoor;
                    flag = false;
                }
            }
    }

    private void openSecondDoor() {
        if(doors[indexChooseDoor].getObjectBehindDoor() == ObjectBehindDoor.CAR && indexChooseDoor != indexOpenDoor) {
            victory = true;
        } else {
            victory = false;
        }
    }

    private void checkVictory(boolean victory, int number) {
        String resultTest;
        if (victory) {
            resultTest = "Победа";
            saveResult(number, resultTest);
            countGamesWon++;
        } else {
            resultTest = "Поражение";
            saveResult(number, resultTest);
        }
    }

    private boolean isVictory() {
        return victory;
    }

    private void saveResult(int number, String resultTest) {
        totalResult.put(number, resultTest);
    }

    public void getTotalResult() {
        for (Map.Entry<Integer, String> entry : totalResult.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Номер игры: " + key + " " + "Результат игры: " + value);
        }
    }

    public void getResultInPercentage() {
        System.out.println("Количество побед в процентах = " + ((countGamesWon * 100) / COUNT_OF_GAMES));
    }

    public void start(boolean typeGame) {
        createDoors();
        while (gameIndex < COUNT_OF_GAMES) {
            chooseDoor();
            openFirstDoor();
            if (typeGame) {
                reChooseDoor();
                openSecondDoor();
                checkVictory(isVictory(), gameIndex);
            } else {
                openSecondDoor();
                checkVictory(isVictory(), gameIndex);
            }
            gameIndex++;
        }
    }

    public void getCountGamesWon() {
        System.out.println("Количество побед = " + countGamesWon);
    }


}




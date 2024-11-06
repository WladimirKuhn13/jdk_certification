package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MontyHallParadox gameWithReChoose = new MontyHallParadox();
        MontyHallParadox gameWithoutReChoose = new MontyHallParadox();

        gameWithReChoose.start(true);
        gameWithoutReChoose.start(false);

        gameWithoutReChoose.getCountGamesWon();
        gameWithReChoose.getCountGamesWon();

        gameWithoutReChoose.getResultInPercentage();
        gameWithReChoose.getResultInPercentage();

        gameWithoutReChoose.getTotalResult();
        gameWithReChoose.getTotalResult();
    }
}
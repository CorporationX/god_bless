package sprint5.starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWars {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7, 8);
        Robot c3po = new Robot("C-3PO", 4, 8, 15);

        Robot newRobot = new Robot("Siren", 2, 5, 20);
        Robot oldRobot = new Robot("GROM", 9, 5, 12);

        Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondWinnerFuture = battle.fight(newRobot, oldRobot);
        battle.shutdownBattle();

        checkWinner(firstWinnerFuture);
        checkWinner(secondWinnerFuture);
    }

    private static void checkWinner(Future<Robot> winnerFuture) {
        try {
            Robot winner = winnerFuture.get();
            System.out.println("Winner: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

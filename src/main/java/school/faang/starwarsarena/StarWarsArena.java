package school.faang.starwarsarena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        handleBattle(battle, r2d2, c3po, "first");
        handleBattle(battle, c3po, bb8, "second");
        handleBattle(battle, r2d2, bb8, "third");
    }

    private static void handleBattle(Battle battle, Robot robot1, Robot robot2, String battleName) {
        Future<Robot> winnerFuture = battle.fight(robot1, robot2);
        try {
            Robot winner = winnerFuture.get();
            System.out.println("The winner of the " + battleName + " battle is: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


package faang.school.godbless.starwars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arena {

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            if (winner == null) {
                System.out.println("Its a draw");
            } else {
                System.out.println("The winner is: " + winner.getName());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdown();
    }
}

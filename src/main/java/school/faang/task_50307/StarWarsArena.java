package school.faang.task_50307;

import java.awt.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> winnerFuture = battle.fight(r2d2, bb8);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

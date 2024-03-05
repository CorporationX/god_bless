package faang.school.godbless.star_wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("R2-D2", 10, 15);
        Robot c2po = new Robot("C2-PO", 8, 12);

        Future<Robot> winnerFuture = battle.fight(r2d2, c2po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Winner of the battle: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

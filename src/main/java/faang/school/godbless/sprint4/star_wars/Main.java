package faang.school.godbless.sprint4.star_wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 4, 8);
        Robot c3po = new Robot("C-3PO", 5, 7);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);


        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

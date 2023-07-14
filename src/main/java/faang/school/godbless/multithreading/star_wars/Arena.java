package faang.school.godbless.multithreading.star_wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arena {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot r3d3 = new Robot("R3-D3", 10, 20);
        Robot c4po = new Robot("C-4PO", 6, 8);

        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(r3d3, c4po);
        battle.endBattle();

        try {
            Robot winner1 = winnerFuture1.get();
            Robot winner2 = winnerFuture2.get();
            System.out.println("Winner: " + winner1.getName());
            System.out.println("Winner: " + winner2.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

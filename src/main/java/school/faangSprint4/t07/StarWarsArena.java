package school.faangSprint4.t07;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> battle1 = battle.fight(r2d2, c3po);
        Future<Robot> battle2 = battle.fight(bb8, c3po);
        Future<Robot> battle3 = battle.fight(r2d2, bb8);

        try {
            System.out.println("Battle 1 winner: " + battle1.get().name());
            System.out.println("Battle 2 winner: " + battle2.get().name());
            System.out.println("Battle 3 winner: " + battle3.get().name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            battle.shutdown();
        }
    }
}
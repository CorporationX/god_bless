package school.faang.star_wars_arena_BJS2_38298;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);
        Robot wallE = new Robot("WALL-E", 7, 9);
        Robot eve = new Robot("EVE", 8, 10);

        List<Future<Robot>> futures = new ArrayList<>(List.of(
                battle.fight(r2d2, c3po),
                battle.fight(bb8, wallE),
                battle.fight(wallE, eve)
        ));
        battle.getService().shutdown();

        futures.forEach((future) -> {
            try {
                System.out.println("Победитель битвы: " + future.get().getName());
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }
        });
    }
}
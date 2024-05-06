package faang.school.godbless.arena;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Robot verter = new Robot("Verter", 9, 6);
        Robot x = new Robot("X", 3, 2);

        List<Future<Robot>> battles = List.of(battle.fight(r2d2, c3po), battle.fight(verter, x));
        battles.forEach(b -> {
            try {
                Robot winner = b.get();
                System.out.println("Победитель битвы - " + winner.getName());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

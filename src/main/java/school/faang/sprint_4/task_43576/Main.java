package school.faang.sprint_4.task_43576;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 6);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 8, 6);

        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(r2d2, bb8);

        try {
            System.out.println("Победитель битвы 1: " + winnerFuture1.get().name());
            System.out.println("Победитель битвы 2: " + winnerFuture2.get().name());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Произошла ошибка!");
        }

        battle.shutdown();
    }
}

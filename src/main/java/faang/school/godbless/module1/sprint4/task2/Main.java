package faang.school.godbless.module1.sprint4.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot robotFirst = new Robot("robotFirst", 10, 3);
        Robot robotSecond = new Robot("robotSecond", 3, 8);
        Battle battle = new Battle();

        List<Future<Robot>> winners = new ArrayList<>();
        winners.add(battle.fight(r2d2,robotSecond));
        winners.add(battle.fight(r2d2,c3po));
        winners.add(battle.fight(r2d2,c3po));
        winners.add(battle.fight(robotFirst,robotSecond));
        battle.shutdownAllThreads();

        winners.forEach(winner -> {
            try {
                System.out.println(winner.get().getName());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


    }
}

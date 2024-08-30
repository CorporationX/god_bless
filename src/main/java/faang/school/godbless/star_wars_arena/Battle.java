package faang.school.godbless.star_wars_arena;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Battle {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 7, 9);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return executorService.submit(() -> {
            if ((robot1.getAttackPower() + robot1.getDefensePower()) >
                    (robot2.getAttackPower() + robot1.getDefensePower())) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }
}

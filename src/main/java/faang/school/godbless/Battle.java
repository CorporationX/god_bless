package faang.school.godbless;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Future<Robot> fight(Robot r1, Robot r2){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        var winner = executor.submit(() -> {
            int powerFirst = r1.getAttackPower()*2 + r1.getDefencePower()*3;
            int powerSecond = r2.getAttackPower()*2 + r2.getDefencePower()*3;
            return (powerFirst > powerSecond ? r1 : r2);
        });
        executor.shutdown();
        return winner;
    }
}

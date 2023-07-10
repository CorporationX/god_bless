package faang.school.godbless.Sprint4Future.Task2StarWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 4, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Future<Robot> fight (Robot first, Robot second){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> submit = executorService.submit(() -> {
            double firstWinnerCoefficient = (double) first.attackPower()/second.defencePower();
            double secondWinnerCoefficient = (double) second.attackPower()/first.defencePower();
            if (firstWinnerCoefficient > secondWinnerCoefficient) {
                return first;
            } else {
                return second;
            }
        });
        executorService.shutdown();
        return submit;
    }
}

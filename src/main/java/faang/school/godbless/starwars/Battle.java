package faang.school.godbless.starwars;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 1);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
    }

    public Future<Robot> fight(Robot first, Robot second) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Robot> winner = executorService.submit(() -> {
            int firstPower = first.getPower() + first.getDefence();
            int secondPower = second.getPower() + second.getDefence();
            return firstPower > secondPower ? first : second;
        });
        executorService.shutdown();
        return winner;
    }
}

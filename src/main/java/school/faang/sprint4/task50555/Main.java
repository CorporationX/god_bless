package school.faang.sprint4.task50555;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50555.model.Battle;
import school.faang.sprint4.task50555.model.Robot;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final int MONITOR_TIME_SEC = 1;

    public static void main(String[] args) {

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);
        Robot terminator = new Robot("Terminator", 8, 7);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Battle battle = new Battle(executor);

        Future<Robot> winnerSemiFinal1 = battle.fight(r2d2, c3po, 10);
        Future<Robot> winnerSemiFinal2 = battle.fight(bb8, terminator, 12);

        while (!winnerSemiFinal1.isDone() && !winnerSemiFinal2.isDone()) {
            try {
                Thread.sleep(MONITOR_TIME_SEC * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Semifinal in progress... Please wait");
        }

        Robot robotSemiFinal1;
        Robot robotSemiFinal2;

        try {
            robotSemiFinal1 = winnerSemiFinal1.get();
            robotSemiFinal2 = winnerSemiFinal2.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        Future<Robot> winnerFinal = battle.fight(robotSemiFinal1, robotSemiFinal2, 5);

        while (!winnerFinal.isDone()) {
            try {
                Thread.sleep(MONITOR_TIME_SEC * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Final in progress... Please wait");
        }

        try {
            Robot winner = winnerFinal.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        executor.shutdown();
    }
}

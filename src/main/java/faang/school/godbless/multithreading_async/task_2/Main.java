package faang.school.godbless.multithreading_async.task_2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final Battle battle = new Battle();
        final Robot r2d2 = new Robot("R2-D2", 5, 7);
        final Robot c3po = new Robot("C-3PO", 4, 8);
        final Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            log.info("Winner of the battle: {}", winner);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while waiting for the integerFuture result", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Exception occurred while trying to get the future result", e);
        } finally {
            battle.shutdownExecutor();
        }
    }
}
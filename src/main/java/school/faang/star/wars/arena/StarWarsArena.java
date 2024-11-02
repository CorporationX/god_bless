package school.faang.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        ArenaTest.getRandomValueTest(getRandomValue());

        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", getRandomValue(), getRandomValue());
        Robot c3po = new Robot("C-3PO", getRandomValue(), getRandomValue());
        Robot bb8 = new Robot("BB-8", getRandomValue(), getRandomValue());

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<Robot>> futures = List.of(
                battle.fight(r2d2, c3po, executor),
                battle.fight(r2d2, bb8, executor),
                battle.fight(bb8, c3po, executor)
        );
        executor.shutdown();

        futures.forEach( w -> {
            try {
                Robot winner = w.get();
                log.info("Победитель битвы: {}", winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    static int getRandomValue() {
        final int MAX_VALUE = 20;
        return new Random().nextInt(MAX_VALUE);
    }
}

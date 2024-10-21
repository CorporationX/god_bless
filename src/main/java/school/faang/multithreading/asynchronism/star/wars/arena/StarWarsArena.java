package school.faang.multithreading.asynchronism.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        List<Future<Robot>> futureBattles = List.of(
                battle.fight(r2d2, c3po),
                battle.fight(bb8, r2d2)
        );

        IntStream.range(0, futureBattles.size()).forEach(i -> {
            try {
                Robot winner = futureBattles.get(i).get();
                log.info("Победитель битвы {}: {}", i + 1, winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}

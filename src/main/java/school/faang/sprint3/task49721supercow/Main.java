package school.faang.sprint3.task49721supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;


@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);
        Player[] players =
                IntStream.range(1, 11)
                        .mapToObj(i -> new Player("Player" + i, boss))
                        .toArray(Player[]::new);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<? extends Future<?>> futures = Arrays.stream(players)
                .map(player -> executor.submit(() -> {
                    try {
                        player.startBattle();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .toList();

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                log.error("Ошибка " + e);
            }
        }

        executor.shutdown();
    }
}

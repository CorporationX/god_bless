package school.faang.BJS2_63823;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(7);
        int awaitTimeout = 10;
        List<Player> players = new ArrayList<>(List.of(
                new Player("Ramil", game),
                new Player("Albert", game),
                new Player("Kamil", game),
                new Player("Vlad", game),
                new Player("Masha", game)
        ));
        ExecutorService executor = Executors.newFixedThreadPool(3);

        players.forEach(player -> executor.submit(player::run));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(awaitTimeout, TimeUnit.SECONDS)) {
                log.error("Не все потоки завершились вовремя, принудительно завершаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

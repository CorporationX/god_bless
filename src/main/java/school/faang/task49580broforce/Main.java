package school.faang.task49580broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Bro firstBro = new Bro("TERMINATOR", 5, true);
        Bro secondBro = new Bro("REMBO", 8, true);

        game.addBro(firstBro);
        game.addBro(secondBro);


        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, game.getBros().size())
                .forEach((i) -> {
                    executor.submit(() -> {
                        while (firstBro.getLives() > 0 && secondBro.getLives() > 0) {
                            boolean gameIsRunning = game.update();
                            log.info("Is anyone dead?  {} ", gameIsRunning);
                        }
                    });
                });
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за указанное время, останавливаем принудительно!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }


    }
}

package school.faang.task_49705;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TIMEOUT = 10;
    private static final int COUNT_MAX_PLAYERS = 3;

    public static void main(String[] args) {

        Boss boss = new Boss(COUNT_MAX_PLAYERS);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Player player1 = new Player("Anna");
        Player player2 = new Player("Timur");
        Player player3 = new Player("Saha");
        Player player4 = new Player("Lin");

        executorService.submit(() -> {
            player1.startBattle(boss);
        });

        executorService.submit(() -> {
            player2.startBattle(boss);
        });

        executorService.submit(() -> {
            player3.startBattle(boss);
        });

        executorService.submit(() -> {
            player4.startBattle(boss);
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.error("Задачи не завершились за {} секунд, останавливаем эту дичь", TIMEOUT);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
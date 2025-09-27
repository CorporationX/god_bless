package school.faang.sprint3.supercow;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Battle {

    private static final Integer THREAD_COUNT = 4;
    private static final Integer PLAYER_COUNT = 10;
    private static final Integer PLAYER_COUNT_MAX = 3;
    private static final Integer TIME_AWAIT_MINUTE = 5;

    public static void main(String[] args) {
        Boss boss = new Boss(PLAYER_COUNT_MAX);
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_COUNT);
        IntStream.range(0, PLAYER_COUNT)
                .forEach(playerIndex -> {
                    Player newPlayer = new Player(playerIndex);
                    executors.execute(() -> newPlayer.doBattle(boss));
                });
        gracefullyShutdown(executors);
    }

    public static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                System.out.println("Босса успешно замочили");
            } else {
                System.out.println("Ошибка ожидания завершения работы");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка при остановке потоков");
        }
    }

}

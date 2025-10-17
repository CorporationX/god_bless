package school.faang.stream3.player;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Music {

    public static final Integer LISTENERS = 9;
    private static final Integer TIME_AWAIT_MINUTE = 5;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {
        Random random = new Random();
        PlayerUsersGenerator playerUsersGenerator = new PlayerUsersGenerator();
        playerUsersGenerator.accept(PlayerAction.PLAY, executorService);
        IntStream.range(0, LISTENERS)
                .forEach(listenerNumber -> {
                    int randomActionIndex = random.nextInt(PlayerUsersGenerator.playerActions.size());
                    PlayerAction randomAction = PlayerUsersGenerator.playerActions.get(randomActionIndex);
                    playerUsersGenerator.accept(randomAction, executorService);
                });
        Music.gracefullyShutdown();
    }

    public static void gracefullyShutdown() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                System.out.println("Все слушатели разругались и больше не слушают треки вместе");
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

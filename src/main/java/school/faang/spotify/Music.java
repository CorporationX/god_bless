package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        executorService.submit(player1::play);
        executorService.submit(player1::pause);
        executorService.submit(player1::skip);
        executorService.submit(player1::previous);

        executorService.submit(player2::play);
        executorService.submit(player2::pause);
        executorService.submit(player2::skip);
        executorService.submit(player2::previous);

        executorService.submit(player3::play);
        executorService.submit(player3::pause);
        executorService.submit(player3::skip);
        executorService.submit(player3::previous);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
        }
        System.out.println("Все действия завершили");
    }
}

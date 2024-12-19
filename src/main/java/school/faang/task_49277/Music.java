package school.faang.task_49277;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(Player::play);
        executor.submit(Player::pause);
        executor.submit(Player::skip);
        executor.submit(Player::previous);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Ваш кринж не завершился за 20 секунд, аварийное отключение...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
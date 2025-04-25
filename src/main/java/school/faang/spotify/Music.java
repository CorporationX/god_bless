package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Thread(player::pause));
        executor.execute(new Thread(player::play));
        executor.execute(new Thread(player::skip));
        executor.execute(new Thread(player::previous));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
        log.info("Все задачи выполнены!");
    }
}

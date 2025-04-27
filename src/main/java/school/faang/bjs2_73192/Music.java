package school.faang.bjs2_73192;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {

    private static final int THREAD_AMOUNT = 4;
    private static final int WAITING_TIME = 5;

    public static void main(String[] args) {
        Player player = new Player();

        Runnable play = player::play;
        Runnable pause = player::pause;
        Runnable skip = player::skip;
        Runnable previous = player::previous;

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

        executor.execute(play);
        executor.execute(pause);
        executor.execute(skip);
        executor.execute(previous);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", WAITING_TIME);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

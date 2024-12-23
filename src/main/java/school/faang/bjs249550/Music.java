package school.faang.bjs249550;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int USERS = 5;
    private static final Player player = new Player();
    private static final Runnable actions1 = () -> {
        player.play();
        sleep();
        player.pause();
    };
    private static final Runnable actions2 = () -> {
        player.pause();
        sleep();
        player.skip();
        sleep();
        player.play();
    };
    private static final Runnable actions3 = () -> {
        player.play();
        sleep();
        player.skip();
        sleep();
        player.skip();
        sleep();
        player.previous();
        sleep();
        player.pause();
    };
    private static final int SLEEP_MILLIS = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(USERS);

        executorService.submit(actions1);
        executorService.submit(actions2);
        executorService.submit(actions3);
        shutdown(executorService);
    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(SLEEP_MILLIS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}


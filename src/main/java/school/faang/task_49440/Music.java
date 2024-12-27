package school.faang.task_49440;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    private static final int NUMBER_OF_CYCLES = 5;

    private static void repeatAction(Runnable action, int sleepTime) {
        for (int i = 0; i < NUMBER_OF_CYCLES; i++) {
            action.run();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> repeatAction(player::play, 1500));
        Thread pauseThread = new Thread(() -> repeatAction(player::pause, 1000));
        Thread skipThread = new Thread(() -> repeatAction(player::skip, 500));
        Thread previousThread = new Thread(() -> repeatAction(player::previous, 1000));
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("All threads have finished.");
    }
}

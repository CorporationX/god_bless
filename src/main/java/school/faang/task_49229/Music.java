package school.faang.task_49229;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    private static final int THREAD_COUNT = 10;
    private static final Thread[] threads = new Thread[THREAD_COUNT];
    private static final int DELAY = 5000;

    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] tasks = new Runnable[]{() -> player.play(),
                                          () -> player.pause(),
                                          () -> player.skip(),
                                          () -> player.previous()};

        for (var i = 0; i < THREAD_COUNT; i++) {
            int taskIndex = (int) (Math.random() * tasks.length);
            threads[i] = new Thread(tasks[taskIndex]);
            threads[i].start();
        }

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.warn("Main thread was interrupted", e);
        }
    }
}

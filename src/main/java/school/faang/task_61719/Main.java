package school.faang.task_61719;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TERMINATION_AWAIT_TIME = 1;
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            int videoId = i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> manager.addView(Integer.toString(videoId)));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_AWAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершились за отведённое время!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток был прерван");
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }
}

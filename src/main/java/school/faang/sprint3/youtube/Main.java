package school.faang.sprint3.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int NUM_THREADS = 100;
    static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            final int a = i;

            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    videoManager.addView("Video_" + a);
                    videoManager.getViewCount("Video_" + a);
                });

                System.out.println("Task count " + ((ThreadPoolExecutor)executor).getTaskCount());
                System.out.println("Task complete " + ((ThreadPoolExecutor)executor).getCompletedTaskCount());
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Tasks was not finished after 1 minutes");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

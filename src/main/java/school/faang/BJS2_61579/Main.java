package school.faang.BJS2_61579;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(VideoManager.NUM_THREADS);

        for (int i = 0; i < VideoManager.NUM_VIDEOS; i++) {
            String strVideo = String.format("Video №%d", i);

            for (int j = 0; j < VideoManager.NUM_THREADS; j++) {
                final int outerIndex = i;
                final int innerIndex = j;

                executorService.submit(() -> {
                    videoManager.addView(strVideo);
                    System.out.println("Task %d%d, %s: has %d views".formatted(
                            outerIndex, innerIndex, strVideo, videoManager.getViewCount(strVideo)));
                });
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("All tasks finished withing 1 second");
            } else {
                System.out.println("Not all tasks finished within 1 second");
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting for all tasks to complete was interrupted");
        }

        if (!executorService.isTerminated()) {
            System.out.println("Force quit remaining tasks");
            executorService.shutdownNow();
        }

        videoManager.getViewsMap().forEach((k, v) -> {
            System.out.println("%s has been %d times viewed".formatted(k, v));
        });
    }
}

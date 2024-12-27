package school.faang.sprint1.task_49313;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final int threadSum = 100;
        final int quantityVideo = 10;
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(threadSum);
        for (int i = 0; i < quantityVideo; i++) {
            String nameVideo = "Video № " + i;
            for (int j = 0; j < threadSum; j++) {
                executor.submit(() -> {
                    manager.addView(nameVideo);
                    System.out.println("Видео " + nameVideo + "просмотры = " + manager.getViewCount(nameVideo));
                });

            }

        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

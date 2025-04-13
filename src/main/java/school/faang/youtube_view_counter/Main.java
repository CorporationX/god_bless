package school.faang.youtube_view_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager youtubeManager = new VideoManager();
        final int NUM_THREADS = 5;
        final int NUM_VIDEOS = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i  = 0; i < NUM_VIDEOS; i++) {
            String curVideo = "Video" + String.valueOf(i + 1);
            youtubeManager.addVideo(curVideo);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> youtubeManager.addView(curVideo));
            }
        }
        executor.shutdown();

        try {
            // Ждем завершения всех задач в течение 60 секунд
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // Если задачи не завершились, принудительно завершаем их
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // Если текущий поток был прерван, принудительно завершаем задачи
            executor.shutdownNow();
        }

        System.out.println(youtubeManager.getViewCount("Video299"));
    }
}

package school.faang.task_61739;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10; // Количество потоков
    private static final int NUM_VIDEOS = 5;   // Количество видео

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String str = "Video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                service.submit(() -> videoManager.addView(str));
                log.info("Video " + str + " просмотров: " + videoManager.getViewCount(str));
            }

        }
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

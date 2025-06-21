package school.faang.viewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ViewCounterTesting {
    private static final Integer NUM_THREADS = 3;
    private static final Integer NUM_VIDEOS = 9;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String id = i + "";
                executor.submit(() -> videoManager.addView(id));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                log.error("Принудительное закрытие пула потоков спустя 5 минут.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = i + "";
            log.info("Video {} просмотров: {}", videoId, videoManager.getViewCount(videoId));
        }
    }
}

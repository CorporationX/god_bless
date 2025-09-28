package school.faang.bjs2_90140;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static final int NUM_THREADS = 5;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService ex = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();
        for (int i = 0; i < NUM_THREADS; i++) {
            String id = "" + random.nextInt(123456789);
            log.info("{} взял в работу видео: {}", Thread.currentThread().getName(), id);
            for (int j = 0; j < NUM_VIDEOS; j++) {
                ex.submit(() -> {
                    manager.addView(id);
                    manager.getViewCount(id);
                });
            }
        }
        ex.shutdown();
        try {
            if (!ex.awaitTermination(15, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("{} has been interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}

package school.faang.bjs2_81705;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREAD = 10000;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService poolThread = Executors.newFixedThreadPool(NUM_THREAD);
        for (int i = 0; i <= NUM_VIDEOS; i++) {
            String nameVideo = "video " + i;
            for (int j = 0; j < NUM_THREAD; j++) {
                poolThread.submit(() -> {
                    videoManager.addView(nameVideo);
                    log.info("Текущее кол-во просмотров у {}: {}", nameVideo, videoManager.getViewCount(nameVideo));
                });
            }
        }

        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи успели завершиться в {} секунд", TIMEOUT);
                poolThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolThread.shutdownNow();
        }

        log.info("{}", videoManager);
    }
}

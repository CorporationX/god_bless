package school.faang.Mnogopotochka.Synhronaized.BJS2_37464;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    static VideoManager videoManager = new VideoManager();
    static ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {

        for(int i = 0; i < NUM_VIDEOS; i++){
            String videoName = "Video: " + i;
            for(int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++){
                executorService.submit(() ->{
                   videoManager.addView(videoName);
                    log.info("Video ID: {} | Views: {}",videoName, videoManager.getViewCount(videoName));
                });
            }
        }

        executorService.shutdown();
        log.info("Ожидание завершения всех задач");

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.warn("Некоторые задачи не завершились вовремя.");
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения было прервано", e);
            Thread.currentThread().interrupt();
        }

        log.info("Завершение программы");

        videoManager.displayAllVideo();
    }
}

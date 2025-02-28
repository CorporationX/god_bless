package school.faang.BJS2_61628;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(ConstAndMessages.NUM_THREADS);

        for (int i = 0; i < ConstAndMessages.NUM_VIDEOS; i++) {
            String videoId = "Video_" + i;
            for (int j = 0; j < ConstAndMessages.NUM_THREADS; j++) {
                executorService.submit(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(ConstAndMessages.TIMEOUT_SHUTDOWN, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        videoManager.viewsStatistic();
    }
}

package school.faang.bjs2_90011;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 10;
    private static final int TIME_WAITING = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.rangeClosed(1, NUM_VIDEOS + 1).forEach(i -> {
            String videoId = appendString("video", i);
            IntStream.range(1, NUM_THREADS + 1).forEach(j -> {
                executor.submit(() -> videoManager.addView(videoId));
                log.info("video {} watch {}", videoId, videoManager.getViewCount(videoId));
            });
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_WAITING, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static String appendString(String str, int i) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str)
                .append(i)
                .toString();
    }
}

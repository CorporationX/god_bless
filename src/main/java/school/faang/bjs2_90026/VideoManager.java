package school.faang.bjs2_90026;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class VideoManager extends VideoViewsCounter {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;
    private static final int TIME_WAITING_THREAD = 1;

    public String buildVideoId(int videoIndex, String video) {
        StringBuilder sb = new StringBuilder();
        sb.append(video).append(videoIndex);
        return sb.toString();
    }

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.rangeClosed(1, NUM_VIDEOS).forEach(videoIndex -> {
            String videoId = manager.buildVideoId(videoIndex, "video");

            IntStream.range(0, NUM_THREADS).forEach(i -> {
                executor.submit(() -> manager.addView(videoId));
            });
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_WAITING_THREAD, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за минуту. Завершаем принудительно...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи успешно завершены.");
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        IntStream.rangeClosed(1, NUM_VIDEOS).forEach(videoIndex -> {
            String videoId = manager.buildVideoId(videoIndex, "video");


            log.info("{} views: {}", videoId, manager.getViewCount(videoId));
        });
    }
}
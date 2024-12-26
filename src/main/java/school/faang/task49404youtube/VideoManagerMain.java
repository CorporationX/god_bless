package school.faang.task49404youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@Slf4j
public class VideoManagerMain {
    public static int NUM_THREADS = 100;
    public static int NUM_VIDEOS = 10;

    public static void main(String[] args) {


        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_VIDEOS)
                .forEach((i) -> {
                    String videoId = "videoId" + i;

                    IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                            .forEach((j) -> {
                                executor.submit(() -> {
                                    videoManager.addView(videoId);
                                    log.info(" video {}  просмотров {} ", videoId, videoManager.getViewCount(videoId));
                                });
                            });

                });
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Не все потоки были завершены в указанное время, останавливаем принудительно .");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}

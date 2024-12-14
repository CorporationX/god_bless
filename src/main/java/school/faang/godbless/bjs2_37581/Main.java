package school.faang.godbless.bjs2_37581;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager manager = new VideoManager();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        String[] videos = new String[NUM_VIDEOS];
        IntStream.range(0, videos.length).forEach(i -> videos[i] = "Video" + i);
        int tasksNumber = NUM_THREADS / NUM_VIDEOS;
        IntStream.range(0, tasksNumber).forEach(i -> pool.submit(
                () -> {
                    String video = videos[ThreadLocalRandom.current().nextInt(videos.length)];
                    manager.addView(video);
                    int views = manager.getViewCount(video).orElse(0);
                    log.info("{} has {} views", video, views);
                }
        ));
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("Program finished successfully");
        } else {
            log.error("Pool not terminated");
            throw new IllegalStateException("Pool not terminated");
        }
    }
}

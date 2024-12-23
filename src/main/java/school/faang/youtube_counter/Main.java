package school.faang.youtube_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static school.faang.youtube_counter.DataSet.NUM_THREADS;
import static school.faang.youtube_counter.DataSet.NUM_VIDEOS;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager manager = new VideoManager();

        IntStream.range(0, NUM_VIDEOS)
                .forEach(i -> {
                    String videoId = "video" + i;
                    IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                            .forEach(j -> executor.submit(() -> {
                                manager.addView(videoId);
                                log.info("{} has {} views", videoId, manager.getViewCount(videoId));
                            }));
                });
        executor.shutdown();
        try {
            if (executor.awaitTermination(3, TimeUnit.SECONDS)) {
                log.info("All tasks finished");
            } else {
                log.info("Time left, some tasks still running");
            }
        } catch (InterruptedException e) {
            log.error("Waiting tasks completing was interrupted");
        }
    }
}

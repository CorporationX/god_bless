package faang.school.godbless.sprint3.youtubeCounter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {

    private static final Integer NUM_THREADS = 20;
    private static final Integer NUM_VIDEOS = 5;

    public static void main(String[] args) {
        try {
            VideoManager videoManager = new VideoManager();

            List<String> videos = Stream.generate(() -> new Random().nextInt(10))
                    .limit(NUM_VIDEOS)
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

            videos.forEach(video -> {
                for (int i = 1; i <= NUM_THREADS / NUM_VIDEOS; i++) {
                    executorService.submit(() -> {
                        videoManager.addView(video);

                        int viewCount = videoManager.getViewCount(video);

                        log.info("{} view count: {}", video, viewCount);
                    });
                }
            });

            executorService.shutdown();

            if (!executorService.awaitTermination(20L, TimeUnit.SECONDS)) {
                System.out.println("Execution service haven't done");
            } else {
                System.out.println("Execution service has done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

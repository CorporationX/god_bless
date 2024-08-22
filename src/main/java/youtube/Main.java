package youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 20;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        var videos = initVideos();
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS)) {
            IntStream.rangeClosed(0, videos.size())
                    .boxed()
                    .flatMap(i -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS).boxed()
                            .map(j -> i))
                    .forEach(idx -> executor.submit(() -> {
                        var video = videos.get(idx);
                        videoManager.addView(video);
                        log.info(String.format("Video with id=%s is %d",
                                video.getId(), videoManager.getViewCount(video)));
                    }));
            executor.shutdown();
            if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Finished\n");
            } else {
                log.info("Time out");
            }
        }
        log.info("");
        videos.forEach(v -> log.info(String.format("Video with id=%s is %d",
                v.getId(), videoManager.getViewCount(v))));
    }

    private static List<Video> initVideos() {
        return IntStream.range(0, NUM_VIDEOS).boxed()
                .map(i -> new Video())
                .toList();
    }
}

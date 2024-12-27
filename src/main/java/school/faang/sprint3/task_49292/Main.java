package school.faang.sprint3.task_49292;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_VIDEOS = 10;
    private static final int NUM_THREADS = 2000;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        IntStream.range(0, NUM_VIDEOS)
                .mapToObj(i -> "video-" + i)
                .forEach(videoManager::addVideo);

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_VIDEOS)
                .mapToObj(i -> "video-" + i)
                .flatMap(videoId -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                        .mapToObj(j -> (Runnable) () -> videoManager.addView(videoId)))
                .forEach(service::submit);

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        videoManager.printViewCount();
    }
}

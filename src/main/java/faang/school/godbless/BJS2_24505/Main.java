package faang.school.godbless.BJS2_24505;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 50;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();

        IntStream.rangeClosed(1, NUM_VIDEOS)
                .forEach(numVideos -> manager.addVideo(Integer.toString(numVideos)));

        System.out.println("Video count: " + manager.getVideoCount());

        for (int i = 0; i < NUM_THREADS; i++) {
            service.execute(() -> {
                manager.addView(Integer.toString(random.nextInt(NUM_VIDEOS)));
                manager.getViewCount(Integer.toString(random.nextInt(NUM_VIDEOS)));
            });
        }

        service.shutdown();
        try {
            if (service.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All threads have finished");
            } else {
                service.shutdownNow();
            }
        } catch (
                InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}

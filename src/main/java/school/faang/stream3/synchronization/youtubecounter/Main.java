package school.faang.stream3.synchronization.youtubecounter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        List<String> videos = Arrays.asList(
                "Cute puppies",
                "Java concurrency",
                "Knitting a scarf",
                "How to repair a car",
                "What means an acute pain in stomach");

        videos.stream()
                .map(video ->
                        videoManager.addVideo(video));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {

            }

        }
    }

}

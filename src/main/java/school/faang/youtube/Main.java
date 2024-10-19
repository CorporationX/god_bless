package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        String[] videos = {"From builder to developer in 4 months",
                "Nazis. Part 2. Barbarossa",
                "Autumn in a Quaint New England Mountain Town",
                "United States Army Basic Combat Training, Fort Jackson | 2023 (1st)",
                "Despacito", "Shape of You, Ed Sheeran", "See You Again, Wiz Khalifa ", "Uptown Funk, Mark Ronson",
                "Gangnam Style, PSY", "\"Masha + porridge\", Masha and the Bear"};

        Map<String, Integer> views = new HashMap<>();
        VideoManager videoManager = new VideoManager(views);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.addView(videos[i]);
        }
        for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
            int finalJ = j;
            executorService.submit(() -> {
                videoManager.addView(videos[finalJ]);
                videoManager.getViewCount(videos[finalJ]);

            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            e.printStackTrace();
            log.error("The current thread is interrupted while waiting for the worker service to complete: ", e);
        }
    }
}

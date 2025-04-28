package school.faang.bjs2_73977;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final List<String> videos = List.of("a", "b", "c", "d", "e", "a", "d", "e", "4");
    private static final int MINUTES_TO_WAIT = 1;

    public static void main(String[] args) {
        ExecutorService threads = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_THREADS; i++) {
            for (String videoId : videos) {
                threads.submit(() -> videoManager.addView(videoId));
            }
        }

        threads.shutdown();
        try {
            if (!threads.awaitTermination(MINUTES_TO_WAIT, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за минуту, принудительно останавливаем...");
                threads.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Принудительное завершение работы");
            threads.shutdownNow();
        }

        for (String videoId : new HashSet<>(videos)) {
            System.out.printf("videoId: %s view count: %s\n", videoId, videoManager.getCount(videoId));
        }
    }
}

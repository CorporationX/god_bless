package school.faang.views.counter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<String> videos = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add("video" + i);
        }
        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            Random random = new Random();
            int videoIndx = random.nextInt(videos.size());
            String videoId = videos.get(videoIndx);
            executor.submit(() -> {
                manager.addView(videoId);
                System.out.println();
                System.out.println(Thread.currentThread().getName() + " Количество просмотров на видео " + videoId + ": " +
                        manager.getView(videoId));
            });
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\nВсе задачи были завершены");
                manager.printReport();
            } else {
                System.out.println("Не все задачи завершились успешно");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}

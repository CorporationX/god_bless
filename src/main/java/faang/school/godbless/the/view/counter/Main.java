package faang.school.godbless.the.view.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        Map<Integer, Integer> viewsMap = new HashMap<>();
        /*
        * Я сделал удобные id для работы с программой. Как я понимаю при создании ролика
        * у нас будет генирироваться для него id  в отдельном сервисе и добавляться в общую базу,
        * у нас это "viewsMap".
        * */
        for(int i = 0; i < NUM_VIDEOS; i++) {
            viewsMap.put(i, 0);
        }
        VideoManager videoManager = new VideoManager(viewsMap);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for(int i = 0; i < NUM_VIDEOS; i++) {
            int videoId = i; // На основании комментария выше
            for(int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video ID: " + videoId + ", View Count: " + videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("We have problem!");
        }
    }
}

package school.faang.BJS237455;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Видео - " + videoId + " просмотров: " + videoManager.getViewCount(videoId));
                });
            }
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Задачи не выполнились вовреся, отрубаемся!");
                service.shutdownNow();
            } else {
                System.out.println("Все закончилось!");
                videoManager.getViewsMap().forEach((key, view) -> System.out.println(key + " просмотров: " + view));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            ;
        }
    }
}

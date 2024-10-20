package school.faang.counteryoutube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTube {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "My Video " + i;
            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                service.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Поток " + Thread.currentThread().getName() + " добавил просмотр к видео: " +
                            videoId + " Всего просмотров: " + videoManager.getViewCount(videoId));
                });
            }
        }
        service.shutdown();
    }
}

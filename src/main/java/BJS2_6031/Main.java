package BJS2_6031;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            manager.addVideo("Видео " + i);
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            String idVideo = "Видео " + new Random().nextInt(manager.getViewsMap().size());
            service.execute(() -> {
                manager.addView(idVideo);
                manager.getViewCount(idVideo);
            });
        }

        service.shutdown();
        try {
            while (!service.awaitTermination(5, TimeUnit.SECONDS)) ;

            manager.getViewsMap().forEach((key, value) -> System.out.println(key + " " + value));
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }
}

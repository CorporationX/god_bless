package school.faang.task325;

import school.faang.task325.video.VideoManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static VideoManager videoManager = new VideoManager();
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            int finalI = i;
            for (int x = 0; x < NUM_THREADS / NUM_VIDEOS; x++) {
                service.submit(() -> {
                    for (int j = 0; j < 25; j++) {
                        try {
                            videoManager.addView("Video " + finalI);
                            System.out.println("Кол-во просмотров у видео " + "Video " + finalI + " " + videoManager.getViewCount("Video " + finalI));
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }
        service.shutdown();
        try {
            if (service.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Ошибка, прерываем все потоки");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}

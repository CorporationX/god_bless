package youtube_1147;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        List<String> videos = new ArrayList<>();
        VideoManager videoManager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            int idVideo = i;
            videos.add("VID_" + idVideo);
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            for (String video : videos) {
                service.execute(() -> {
                    videoManager.addView(video);
                    System.out.println(" Количество просмотров " + video + " - " + videoManager.getViewCount(video));
                });
            }
        }
        service.shutdown();
        try {
            service.awaitTermination(200, TimeUnit.SECONDS);
            System.out.println("Завершено");
        } catch (InterruptedException e) {
            System.out.println("Выполнение потоков прервано");
        }
    }
}
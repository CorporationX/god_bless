package faang.school.godbless.BJS2_24548;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        VideoManager videoManager = new VideoManager();

        final int NUM_THREADS = 50;
        final int NUM_VIDEOS = 5;
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videos = new ArrayList<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videos.add("video" + i);
        }
        videos.forEach(video -> {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.execute(() -> {
                    videoManager.addView(video);
                    System.out.println("Video with id " + video + " has " + videoManager.getViewCount(video) + " views");
                });
            }
        });
        service.shutdown();
        if (service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("The program is completed");
        } else {
            System.out.println("Waiting time exceeded");
        }
        videoManager.getViewsMap().forEach((v, i) -> System.out.println("Total views " + i));
    }
}

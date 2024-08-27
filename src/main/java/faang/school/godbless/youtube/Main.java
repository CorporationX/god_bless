package faang.school.godbless.youtube;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i <NUM_VIDEOS ; i++) {
            Video video = new Video(Integer.toString(i));
            manager.addVideo(video, random.nextInt(0, 200_000_000));
            service.execute(() ->
            {
                manager.addView(video);
                System.out.println("id : " + (video.getId()) + "; " +
                        "количество просмотров : " + manager.getViewCount(video));
            });
        }

        service.shutdown();
        try {
            if (service.awaitTermination(1, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

package youtube_views_counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 1000;
    private final static int NUM_VIDEOS = 5;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videoIds = generateVideos();

        videoIds.forEach(videoId -> {
            videoManager.addVideo(videoId);
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    int videoViews = videoManager.getViewCount(videoId);
                    System.out.printf("Видео с id %s имеет %d просмотров%n", videoId, videoViews);
                });
            }
        });

        executorService.shutdown();
        videoManager.printInfoAboutAllVideos();
        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Программа успешно выполнена");
        } else {
            System.out.println("Время выполнение программы превышено");
        }
    }

    private static List<String> generateVideos() {
        List<String> videos = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add(String.valueOf(i));
        }
        return videos;
    }
}

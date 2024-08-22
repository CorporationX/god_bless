package faang.school.godbless.YouTubeViewCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 2;
    private final static int NUM_VIDEOS = 10;
    private final static List<Video> VIDEOS = new ArrayList<>();

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            VIDEOS.add(new Video(("видео " + i), i));
        }

        for (int i = 0; i < VIDEOS.size(); i++) {
            executorService.execute(() -> {
                Video currentVideo = getRandomVideo();
                videoManager.addViewToVideo(currentVideo);
                System.out.println("просмотры: " + videoManager.getViewCount(currentVideo) + " " + currentVideo.getTitle());
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                executorService.shutdownNow();
            }
            System.out.println("good ending: youtube not slowed down (done)");
        } catch (InterruptedException e) {
            System.out.println("HAHAHA I SLOWED DOWN YOUTUBE");
            throw new RuntimeException(e);
        }
    }

    public static Video getRandomVideo() {
        return VIDEOS.get(ThreadLocalRandom.current().nextInt(VIDEOS.size()));
    }
}

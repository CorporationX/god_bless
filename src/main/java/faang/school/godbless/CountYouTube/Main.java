package faang.school.godbless.CountYouTube;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREAD = 50;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);

        List<Video> videos = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add(new Video("video " + i));
        }
        for (Video video : videos) {
            for (int i = 0; i < NUM_THREAD; i++) {
                if (i % 2 == 0) {
                    executorService.submit(() -> {
                        try {
                            videoManager.addView(video);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } else {
                    executorService.submit(() -> videoManager.getViewCount(video));
                }
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(4, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи выполнены!");
            } else {
                System.out.println("Все задачи выполнены");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

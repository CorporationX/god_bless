package faang.school.godbless.youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int NUM_THREADS = 100;
  private static final int NUM_VIDEOS = 150;
  public static void main(String[] args) {
    VideoManager videoManager = new VideoManager();

    ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    List<String> videosIds = new ArrayList<>();

    for (int i = 0; i < NUM_VIDEOS; i++) {
      videosIds.add("Uniq-video-id" + i);
    }

    videosIds.forEach((String videoId) -> {
      executorService.submit(() -> {
        videoManager.addView(videoId);
        System.out.println(videoManager.getViewCount(videoId));
      });
    });

    videosIds.forEach((String videoId) -> {
      executorService.submit(() -> {
        videoManager.addView(videoId);
        System.out.println(videoManager.getViewCount(videoId));
      });
    });

    executorService.shutdown();

    try {
      executorService.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

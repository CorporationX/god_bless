package school.faang.multithreading.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int NUM_THREADS = 100;
  private static final int NUM_VIDEOS = 10;
  private static final int MAX_WAITING_TIME = 10;

  public static void main(String[] args) throws InterruptedException {

    VideoManager videoManager = new VideoManager();

    ExecutorService viewsService = Executors.newFixedThreadPool(NUM_THREADS);

    for (int i = 0; i < NUM_VIDEOS; i++) {
      String videoId = "video " + i;
      for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
        viewsService.execute(() -> {
          videoManager.addView(videoId);
          videoManager.getViewCount(videoId);
        });
      }
    }
    viewsService.shutdown();

    if (!viewsService.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
      viewsService.shutdownNow();
      if (!viewsService.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
        System.out.println("the pool did not terminate");
      }
    }

    for (var entry : videoManager.getViews().entrySet()) {
      System.out.println(entry.getKey() + " :: " + entry.getValue());
    }

  }

}

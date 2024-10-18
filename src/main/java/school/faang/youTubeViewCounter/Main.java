package school.faang.youTubeViewCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int NUM_THREADS = 100;
  private static final int NUM_VIDEOS = 10;

  public static void main(String[] args) {
    VideoManager videoManager = new VideoManager();

    List<Video> videos = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < NUM_VIDEOS; i++) {
      String videoId = "video " + i;
      String videoName = String.valueOf(random.nextInt(1000));

      videos.add(new Video(videoId, videoName));
    }

    ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    for (Video video : videos) {
      executorService.submit(() -> {
        videoManager.addView(video.getId());
        System.out.printf("на видео %s добавлен еще 1 просмотр, всего просмотров -> %d\n",
            video.getId(),
            videoManager.getViewCount(video.getId()));
      });
    }

    executorService.shutdown();

    try {
      if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался завершения других потоков\n", Thread.currentThread().getName());
      }else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}

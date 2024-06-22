package faang.school.godbless.sprint2.youtube;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

  private final static int NUM_THREADS = 100;
  private final static int NUM_VIDEOS = 5;

  public static void main(String[] args) {
    Map<Video, Long> videos = createVideos();
    VideoManager videoManager = new VideoManager(videos);
    ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    for (Video video : videos.keySet()) {
      for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
        executorService.execute(() -> {
          videoManager.addView(video.getId());
        });
      }
    }

    executorService.shutdown();
    try {
      if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
      }
    }
    catch (InterruptedException e) {
      log.error(e.getMessage());
      executorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
    log.info("Finish " + videos);
  }

  public static Map<Video, Long> createVideos() {
    return IntStream.range(0, NUM_VIDEOS)
        .boxed()
        .collect(Collectors.toMap(i -> new Video("Video_" + i), i -> 0L));
  }
}

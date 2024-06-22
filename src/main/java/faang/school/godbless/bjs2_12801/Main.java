package faang.school.godbless.bjs2_12801;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

  private static final int POOL_SIZE = 500;
  private static final int VIDEO_QUANTITY = 10;
  private static final long TIME_OUT = 30;
  private static final String VIDEO = "Видео";

  public static void main(String[] args) {
    VideoManager videoManager = new VideoManager();

    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.getAndIncrement();

    Stream.generate(() -> new Video(atomicInteger.getAndIncrement(), VIDEO))
        .limit(VIDEO_QUANTITY)
        .forEach(video -> {
          for (int i = 0; i < POOL_SIZE/VIDEO_QUANTITY; i++) {
              executorService.execute(() -> videoManager.addView(video));
              executorService.execute(() -> videoManager.showViewCount(video));
          }
        });

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}

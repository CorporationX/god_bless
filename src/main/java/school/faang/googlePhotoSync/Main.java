package school.faang.googlePhotoSync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int THREAD_POLL_SIZE = 5;

  public static void main(String[] args) {
    List<Photo> photos =List.of(
        new Photo("sea", "photos/sea.png"),
        new Photo("home", "photos/home.png"),
        new Photo("me", "photos/me.png")
    );
    GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POLL_SIZE);

    executorService.submit(googlePhotosAutoUploader::startAutoUpload);
    executorService.submit(googlePhotosAutoUploader::startAutoUpload);
    executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(photos.get(0)));

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(photos.get(1)));
    executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(photos.get(2)));

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    executorService.submit(googlePhotosAutoUploader::stopAutoUpload);
    executorService.shutdown();
    try {
      if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался выполнения всех поток и завершил работу\n", Thread.currentThread().getName());
      }else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
      executorService.shutdownNow();
    }
  }
}

package school.faang.multithreading.photo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GooglePhotos {

  private static final int CORE_POOL_SIZE = 4;

  public static void main(String[] args) {
    GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    List<String> peoplePhotosCollection = new java.util.ArrayList<>(
        List.of("people1.jpg", "people2.jpg", "people3.jpg", "people4.jpg", "people5.jpg"));

    ExecutorService photosProvider = Executors.newCachedThreadPool();
    for (String path : peoplePhotosCollection) {
      photosProvider.execute(() -> {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        uploader.oneNewPhotoAdded(path);
        peoplePhotosCollection.remove(path);

        if (peoplePhotosCollection.isEmpty()) {
          System.out.println("photos provider is shutting down");
          photosProvider.shutdown();
        }
      });
    }
    ScheduledExecutorService uploaderService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
    uploaderService.scheduleAtFixedRate(() -> {
      try {
        uploader.startAutoUpload();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      if (peoplePhotosCollection.isEmpty()) {
        uploaderService.shutdown();
        System.out.println("uploader service is shutting down");
      }
    }, 0, 1, TimeUnit.SECONDS);
  }

}

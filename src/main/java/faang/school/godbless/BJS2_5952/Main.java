package faang.school.godbless.BJS2_5952;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  private static final int NUM_THREADS = 2;
  public static void main(String[] args) {
    GooglePhoto googlePhoto = new GooglePhoto("path");
    GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    ExecutorService executors = Executors.newFixedThreadPool(NUM_THREADS);

    executors.execute(() -> uploader.onNewPhotoAdded(googlePhoto.getPath()));
    executors.execute(uploader::startAutoUpload);

    executors.shutdown();
  }
}

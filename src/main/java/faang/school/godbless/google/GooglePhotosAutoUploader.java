package faang.school.godbless.google;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
  private final Lock lock = new ReentrantLock();
  private final List<String> photosToUpload = new ArrayList<>();

  public void startAutoUpload() throws InterruptedException {
    while (true) {
      synchronized (lock) {
        if (photosToUpload.isEmpty()) {
          System.out.println("No photos to upload");
          lock.wait();
        }
        uploadPhotos();
      }
    }
  }

  public void onNewPhotoAdded(String photoPath) {
    synchronized (lock) {
      photosToUpload.add(photoPath);
      System.out.println("The new photo was added");
      lock.notify();
    }
  }

  private void uploadPhotos() {
    photosToUpload.forEach(System.out::println);
    photosToUpload.clear();
  }
}

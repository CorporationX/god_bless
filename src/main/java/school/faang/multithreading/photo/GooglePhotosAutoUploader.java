package school.faang.multithreading.photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

  private final Object lock = new Object();
  private final List<String> photosToUpload = new ArrayList<>();

  public void startAutoUpload() throws InterruptedException {
    synchronized (lock) {
      if (photosToUpload.isEmpty()) {
        lock.wait();
      }
      uploadPhotos();
    }
  }

  private void uploadPhotos() {
    System.out.println();
    System.out.println("[ * uploaded to Google Photos * ] :");
    photosToUpload.forEach(System.out::println);
    System.out.println(" ...");
    photosToUpload.clear();
  }

  public void oneNewPhotoAdded(String photoPath) {
    synchronized (lock) {
      photosToUpload.add(photoPath);
      lock.notify();
      System.out.println(photoPath + "  > added to upload list >");
    }
  }

}

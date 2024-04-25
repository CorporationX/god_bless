package faang.school.godbless.BJS2_5952;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
  private final static Object LOCK = new Object();
  private List<String> photosToUpload = new ArrayList<>();

  public void startAutoUpload() {
    synchronized (LOCK) {
      while (!Thread.interrupted()) {
        if (photosToUpload.isEmpty()) {
          System.out.println("Photos is empty");
          try {
            LOCK.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        uploadPhotos();
      }
    }
  }

  public void onNewPhotoAdded(String photoPath) {
    synchronized(LOCK) {
      photosToUpload.add(photoPath);
      LOCK.notify();
    }
  }

  public void uploadPhotos() {
    photosToUpload.forEach(s -> System.out.println("Photo " + s + " download"));
    photosToUpload = new ArrayList<>();
  }
}

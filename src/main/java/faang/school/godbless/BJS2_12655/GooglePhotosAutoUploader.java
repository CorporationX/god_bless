package faang.school.godbless.BJS2_12655;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
  private static final Object LOCK = new Object();
  private List<String> photosToUpload = new ArrayList<>();

  public void startAutoUpload() {
    synchronized (LOCK) {
      while (photosToUpload.isEmpty()) {
        try {
          System.out.println("Ожидаем новых фото");
          LOCK.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      uploadPhotos();
    }
  }

  public void onNewPhotoAdded(String photoPath) {
    synchronized (LOCK) {
      photosToUpload.add(photoPath);
      System.out.println("Добавлено новое фото: " + photoPath);
      LOCK.notify();
    }
  }

  private void uploadPhotos() {
    for (String path : photosToUpload) {
      System.out.println("Фото " + path + " загруженно");
    }
    photosToUpload.clear();
  }
}

package faang.school.godbless.sprint2.googlePhotos;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class GooglePhotosAutoUploader {
  private final Object lock = new Object();
  private List<String> photosToUpload = new ArrayList<>();

  @SneakyThrows
  public void startAutoUpload() {
    synchronized (lock) {
      while (true) {
        if (photosToUpload.isEmpty()) {
          log.info("Фоток больше нет. Ждем...");
          lock.wait();
        }
        String path = photosToUpload.get(photosToUpload.size() - 1);
        photosToUpload.remove(photosToUpload.size() - 1);
        Thread.sleep(1000);
        log.info(path + ": файл отправлен");
      }
    }
  }

  public void onNewPhotoAdded(String photoPath) {
    synchronized (lock) {
      photosToUpload.add(photoPath);
      log.info("Добавлено новое фото " + photoPath);
      lock.notify();
    }
  }
}

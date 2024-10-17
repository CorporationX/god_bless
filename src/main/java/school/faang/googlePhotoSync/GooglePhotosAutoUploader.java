package school.faang.googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
  private final List<Photo> photosToUpload = new ArrayList<>();
  private final Object lock = new Object();
  private boolean isActive = false;

  public void startAutoUpload() {
    synchronized (lock) {
      isActive = true;

      while (isActive) {
        if (photosToUpload.isEmpty()) {
          System.out.printf("фотографий больше нет, поток %s ждёт :)\n", Thread.currentThread().getName());
          try {
            lock.wait();
          } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
          }
        }

        if(isActive) {
          System.out.printf("поток %s вызвал метод uploadPhotos()\n", Thread.currentThread().getName());
          uploadPhotos();
        }else {
          System.out.println("GooglePhotosAutoUploader был остановлен");
        }
      }
    }
  }

  public void stopAutoUpload() {
    synchronized (lock) {
      isActive = false;
      lock.notifyAll();
    }
  }

  public synchronized void onNewPhotoAdded(Photo photo) {
    synchronized (lock) {
      photosToUpload.add(photo);
      lock.notify();
      System.out.printf("поток %s добавил фото и уведомил об этом\n", Thread.currentThread().getName());
    }
  }

  private synchronized void uploadPhotos() {
    System.out.println("Фотографии %s загруженна на сервер");
    photosToUpload.clear();
  }
}

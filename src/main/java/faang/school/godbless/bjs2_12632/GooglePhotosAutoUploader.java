package faang.school.godbless.bjs2_12632;

import static faang.school.godbless.ColorScheme.BLUE;
import static faang.school.godbless.ColorScheme.GREEN;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GooglePhotosAutoUploader {

  private static final String LOAD_PHOTO = " Загружаем фото %s на Google Photos.";
  private static final String PHOTO_BEEN_UPLOADED = " Фотография %s была загружена в папку на компьютере.";
  private static final String DELETE_PHOTO = " Фотография %s была удалена с  компьютера.";
  private static final String QUANTITY_PHOTO_IN_COMPUTER = " Кол-во фото на компьютере %d.";

  private final List<String> photosToUpload = new ArrayList<>();

  public void startAutoUpload() {
    synchronized (photosToUpload) {
      while (photosToUpload.isEmpty()) {
        try {
          photosToUpload.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      final int currentIndex = new Random().nextInt(photosToUpload.size());
      final String currentPhoto = photosToUpload.get(currentIndex);
      System.out.println(GREEN.getColor() + Thread.currentThread().getName() +
          String.format(LOAD_PHOTO, currentPhoto));
      photosToUpload.remove(currentIndex);
      System.out.println(GREEN.getColor() + Thread.currentThread().getName() +
          String.format(DELETE_PHOTO, currentPhoto));
      System.out.println(GREEN.getColor() + Thread.currentThread().getName() +
          String.format(QUANTITY_PHOTO_IN_COMPUTER, photosToUpload.size()));
      photosToUpload.notify();
    }
  }

  public void uploadPhotos() {
    synchronized (photosToUpload) {
      while (photosToUpload.size() >= 5) {
        try {
          photosToUpload.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      final String currentPhoto = UUID.randomUUID().toString();
      onNewPhotoAdded(currentPhoto);

      System.out.println(BLUE.getColor() + Thread.currentThread().getName() +
          String.format(PHOTO_BEEN_UPLOADED, currentPhoto));
      System.out.println(BLUE.getColor() + Thread.currentThread().getName() +
          String.format(QUANTITY_PHOTO_IN_COMPUTER, photosToUpload.size()));
      photosToUpload.notify();
    }
  }

  private void onNewPhotoAdded(String photoPath) {
    photosToUpload.add(photoPath);
  }

}

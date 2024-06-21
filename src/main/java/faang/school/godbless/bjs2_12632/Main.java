package faang.school.godbless.bjs2_12632;

import static faang.school.godbless.ColorScheme.RESET;

public class Main {

  private static final String ALL_PHOTOS_UPLOAD = "Все фотографии были загружены!";

  public static void main(String[] args) {
    GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

    Thread uploadPhotos = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        googlePhotosAutoUploader.uploadPhotos();
      }
    });

    Thread autoUpload = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        googlePhotosAutoUploader.startAutoUpload();
      }
    });

    uploadPhotos.start();
    autoUpload.start();

    try {
      autoUpload.join();
      uploadPhotos.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(RESET.getColor() + ALL_PHOTOS_UPLOAD);

  }

}

package faang.school.godbless.sprint2.googlePhotos;

import java.util.Random;

import lombok.SneakyThrows;

/**
 * @author Evgenii Malkov
 */
public class Main {

  @SneakyThrows
  public static void main(String[] args) {
    Random random = new Random();
    GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    Thread uploadThread = new Thread(uploader::startAutoUpload, "Upload");
    uploadThread.start();

    for (int i = 0; i < 100; i++) {
      Thread addPhoto = new Thread(() -> uploader.onNewPhotoAdded(
          random.nextInt(0, 1000) + "/user.png"), "Add");
      addPhoto.start();
      if (i % 3 == 0) {
        Thread.sleep(2000);
      }
    }
  }
}

package faang.school.godbless.google;

public class GooglePhoto {
  public static void main(String[] args) throws InterruptedException {
    GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    Thread uploadThread = new Thread(() -> {
      try {
        uploader.startAutoUpload();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread newPhotoThread = new Thread(() -> uploader.onNewPhotoAdded("photo.jpg"));

    uploadThread.start();
    newPhotoThread.start();

    // Just timeout emulation for test another thread
    try {
      Thread.sleep(5 * 1000);

      Thread anotherPhotoThread = new Thread(() -> uploader.onNewPhotoAdded("another-photo.jpg"));
      anotherPhotoThread.start();
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }
}

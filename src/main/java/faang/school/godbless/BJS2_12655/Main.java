package faang.school.godbless.BJS2_12655;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> photos = List.of("path", "path2", "path3");
    GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();

    for (String photo : photos) {
      Thread upload = new Thread(photosAutoUploader::startAutoUpload);
      Thread added = new Thread(() -> photosAutoUploader.onNewPhotoAdded(photo));

      upload.start();
      added.start();
    }
  }
}

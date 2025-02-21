package school.faang.sprint.third.googlephoto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of(
                "https://www.googleapis.com/photos/v1/uploads/img.img",
                "https://www.googleapis.com/photos/v1/uploads/img1.img",
                "https://www.googleapis.com/photos/v1/uploads/img2.img",
                "https://www.googleapis.com/photos/v1/uploads/img3.img"
        );
        Thread uploadPhotosThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread onNewPhotoAddedThread = new Thread(() ->
                photos.forEach(googlePhotosAutoUploader::onNewPhotoAdded));
        uploadPhotosThread.start();
        onNewPhotoAddedThread.start();
    }
}

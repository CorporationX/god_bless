package faang.school.godbless.GooglePhotoSync;

import java.util.List;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of(
                "a1", "a2", "a3", "a4"
        );

        Thread loadThread = new Thread(() -> photos.forEach(googlePhotosAutoUploader::onNewPhotoAdded));
        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        loadThread.start();
        uploadThread.start();
    }
}

package faang.school.godbless.Google;

import lombok.SneakyThrows;

public class GooglePhoto {
    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addThread = new Thread(() -> uploader.onNewPhotoAdded("photo.jpg"));

        uploadThread.start();
        addThread.start();
        uploadThread.join();
        addThread.join();
    }
}

package school.faang.task61886;

import school.faang.task61886.service.GooglePhotosAutoUploader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread photoAdder = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\Pictures9");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\Pictures10");
        });
        photoAdder.start();
        Thread.sleep(100);
        uploadThread.start();

        photoAdder.join();
        uploadThread.join();
    }
}
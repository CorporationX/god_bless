package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        final GooglePhotosAutoUploader test = new GooglePhotosAutoUploader();
        final GooglePhotosAutoUploader test2 = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                test.uploadPhotos();
            } catch (InterruptedException e) {
                log.info("Поток загрузки был прерван");
                Thread.currentThread().interrupt();
            }
        });
        uploadThread.start();

        test.onNewPhotoAdded("C:/photos/new1.jpg");
        test.onNewPhotoAdded("C:/photos/new2.jpg");

        Thread uploadAvtoThread = new Thread(() -> {
            try {
                test2.startAutoUpload();
            } catch (InterruptedException e) {
                log.info("Поток автоматической загрузки был прерван");
                Thread.currentThread().interrupt();
            }
        });
        uploadAvtoThread.start();

        test2.onNewPhotoAdded("C:/photos/new3.jpg");
        test2.onNewPhotoAdded("C:/photos/new4.jpg");
    }
}

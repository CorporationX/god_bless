package school.faang.google_foto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(autoUploader::startAutoUpload);

        Thread photoSaver = new Thread(() -> {
            try {
                autoUploader.onNewPhotoAdded("~/images/photo_1.jpeg");
                Thread.sleep(1000);
                autoUploader.onNewPhotoAdded("~/images/photo_2.jpeg");
            } catch (InterruptedException e) {
                log.info("Thread running was stopped");
                Thread.currentThread().interrupt();
            }
        });

        uploader.start();
        photoSaver.start();
    }
}

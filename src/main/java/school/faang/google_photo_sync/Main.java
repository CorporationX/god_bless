package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // симуляция задержки
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(500);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(500);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("PhotoAdderThread прерван", e);
            }
        }, "PhotoAdderThread");

        uploadThread.start();
        photoAdderThread.start();
    }
}
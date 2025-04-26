package school.faang.sprint3multythreading.googlephotosync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread thread1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Фотка №"));

        Thread thread2 = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("InterruptedException: {}", e.getMessage());
            }
        });

        thread1.start();
        thread2.start();

    }
}
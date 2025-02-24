package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread addedThread = new Thread(() -> uploader.onNewPhotoAdded("photo"));
        Thread uploadedThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.error("Поток прерван - {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
        });
        addedThread.start();
        uploadedThread.start();
    }
}

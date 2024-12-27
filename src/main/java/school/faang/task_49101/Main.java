package school.faang.task_49101;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread addPhotoThread = new Thread(() -> {
            try {
                for (int i = 1; i < 5; i++) {
                    String newPhoto = "photo" + i;
                    uploader.onNewPhotoAdded(newPhoto);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Adding a photo is interrupted");
            }
        });
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("The main thread is interrupted.");
        }

        log.info("Thee task is finished");
    }
}

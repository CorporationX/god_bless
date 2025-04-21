package school.faang.google.photo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int MIN_SLEEP_MS = 500;
    private static final int MAX_SLEEP_MS = 2000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread addPhotoThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String photoPath = String.format("photo_%s.jpg", i);
                    uploader.onNewPhotoAdded(photoPath);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Поток добавления фото прерван.");
            }
        });

        uploadThread.start();
        addPhotoThread.start();

        try {
            addPhotoThread.join();
            uploadThread.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

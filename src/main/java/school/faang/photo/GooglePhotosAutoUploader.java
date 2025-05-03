package school.faang.photo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    log.info("No new photos. Waiting...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added: {}", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String photoPath = photosToUpload.remove(0);
            log.info("Uploading photo: {}", photoPath);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        uploadThread.start();
        photoAdderThread.start();

        try {
            photoAdderThread.join();
            uploadThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Program finished.");
    }
}

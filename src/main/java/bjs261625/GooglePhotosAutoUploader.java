package bjs261625;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GooglePhotosAutoUploader implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    final Object lock = new Object();
    public static volatile List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload != null) {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                LOGGER.info("Current thread {} start uploading: ", Thread.currentThread().getName());
                uploadPhotos();
                LOGGER.info("Current thread {} has finished uploading ", Thread.currentThread().getName());
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            if (Objects.nonNull(photoPath) && !photoPath.isEmpty()) {
                photosToUpload.add(photoPath);
                LOGGER.info("Thread {} added photo {}", Thread.currentThread().getName(), photoPath);
                lock.notify();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            if (Objects.nonNull(photosToUpload) && !photosToUpload.isEmpty()) {
                GooglePhotosAutoUploader.photosToUpload
                        .forEach(photo -> LOGGER.info("Photo {} are uploading on server", photo));
                GooglePhotosAutoUploader.photosToUpload = new ArrayList<>();
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}

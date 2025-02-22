package bjs261625;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader implements Runnable {
    private final Object lock = new Object();
    public List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            LoggerFactory.getLogger(GooglePhotosAutoUploader.class).info("Current thread {} start uploading: ",
                    Thread.currentThread().getName());
            uploadPhotos();
            LoggerFactory.getLogger(GooglePhotosAutoUploader.class).info("Current thread {} has finished uploading ",
                    Thread.currentThread().getName());
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            if (Objects.nonNull(photoPath) && !photoPath.isEmpty()) {
                photosToUpload.add(photoPath);
                LoggerFactory.getLogger(GooglePhotosAutoUploader.class).info("Thread {} added photo {}",
                        Thread.currentThread().getName(), photoPath);
                lock.notify();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            if (Objects.nonNull(photosToUpload) && !photosToUpload.isEmpty()) {
                photosToUpload
                        .forEach(photo -> LoggerFactory.getLogger(GooglePhotosAutoUploader.class)
                                .info("Photo {} are uploading on server", photo));
                photosToUpload = new ArrayList<>();
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LoggerFactory.getLogger(GooglePhotosAutoUploader.class)
                    .error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}

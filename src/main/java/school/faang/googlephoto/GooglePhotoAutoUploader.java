package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@Slf4j
public class GooglePhotoAutoUploader {

    private final Object lock = new Object();
    private final Queue<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Caught exception", e);
                    throw new IllegalStateException(
                            String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                    );
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        log.info("Uploading photos...");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String path) {
        Objects.requireNonNull(path, "Path cannot be null");
        synchronized (lock) {
            log.info("New photo added: {}", path);
            photosToUpload.add(path);
            lock.notify();
        }
    }
}

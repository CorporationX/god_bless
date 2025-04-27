package school.faang.bjs2_73900;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> paths = new ArrayList<>();
    private long maxWaitTime = 10_000;

    public void onNewPhotoAdded(String photoPath) {
        synchronized (paths) {
            paths.add(photoPath);
            paths.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (paths) {
            paths.stream()
                .forEach(path -> {
                    log.info("Photo has been uploaded to {}.", path);
                });
            paths.clear();
        }
    }

    public void startAutoUpload() {
        long startTime = System.currentTimeMillis();
        long cutOffTime = 10_000;

        while (System.currentTimeMillis() - startTime < cutOffTime) {
            synchronized (paths) {
                if (paths.isEmpty()) {
                    try {
                        log.info("Waiting for new photos...");
                        paths.wait(maxWaitTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Process was interrupted. {}.", e.getMessage());
                    }
                }
                uploadPhotos();
            }
        }
    }

}

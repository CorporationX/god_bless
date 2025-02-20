package school.faang.googlephotosync;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    if (photosToUpload.isEmpty()) {
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn(e.getMessage());
                    break;
                }
            }
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            log.info("New photo added: {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        log.info("Search photo is upload");
        photosToUpload.clear();
    }
}

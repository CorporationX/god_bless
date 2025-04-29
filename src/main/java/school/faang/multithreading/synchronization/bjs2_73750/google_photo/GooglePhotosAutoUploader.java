package school.faang.multithreading.synchronization.bjs2_73750.google_photo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class GooglePhotosAutoUploader {
    private final long duration;
    private final Object lock = new Object();
    private static final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    @SneakyThrows
    public void startAutoUpload() {
        long start = System.currentTimeMillis();
        synchronized (lock) {
            while (System.currentTimeMillis() - start < this.duration) {
                if (photosToUpload.isEmpty()) {
                    log.info("Thread is waiting for photos to upload...");
                    lock.wait(this.duration);
                    if (photosToUpload.isEmpty()) {
                        log.info("Time of waiting for photos to upload is ended");
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }

    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Photo is uploaded and removed from list: {}", photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("New photo added: {}", photoPath);
            photosToUpload.add(photoPath);
            log.info("photosToUpload list = {}", photosToUpload);
            lock.notify();
        }
    }
}


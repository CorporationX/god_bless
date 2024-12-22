package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private final long startTime;
    private final int uploaderWorkTime = 6_000;
    private final int addNewPhotoInterval = 1_000;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
        startTime = System.currentTimeMillis();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            do {
                if (photosToUpload.isEmpty()) {
                    try {
                        log.info("Waiting for new photos to come");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    uploadPhotos();
                }
            } while (System.currentTimeMillis() - startTime < uploaderWorkTime);
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            log.info("adding new photo ....");
            photosToUpload.add(photoPath);
            lock.notify();
            try {
                Thread.sleep(addNewPhotoInterval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("{} is uploaded to server", photo);
        }
        photosToUpload.clear();
    }
}



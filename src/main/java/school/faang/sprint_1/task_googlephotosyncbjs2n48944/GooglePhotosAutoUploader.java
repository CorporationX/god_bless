package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload;
    private List<String> photosToPrepare;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public synchronized void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                log.info("Waiting for new photos to come");
                lock.wait();
            } else {
                uploadPhotos();
            }
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void addNewPhoto() {
        onNewPhotoAdded("Photo_" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("mm_ss.SSS")));
    }

    private void uploadPhotos() {
        for(String photo: photosToUpload) {
            log.info("{} is uploaded to server", photo);
        }
        photosToUpload.clear();
    }
}

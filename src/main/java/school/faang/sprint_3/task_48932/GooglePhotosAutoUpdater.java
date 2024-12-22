package school.faang.sprint_3.task_48932;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUpdater {
    private static final int PHOTO_PROCESSING_DELAY_MS = 3000;
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                log.info("Waiting new photos...");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        log.info("Loading photos on server...");
        photosToUpload.clear();
    }

    @SneakyThrows
    public void onNewPhotoAdded(String photoPath) {
        Thread.sleep(PHOTO_PROCESSING_DELAY_MS);
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Add new photo");
            lock.notify();
        }
    }
}

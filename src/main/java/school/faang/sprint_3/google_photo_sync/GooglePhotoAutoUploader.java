package school.faang.sprint_3.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private static List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        do {
            synchronized (lock) {
                Objects.requireNonNull(photosToUpload, "Nothing to Upload");
                uploadPhotos();
            }
        } while (true);
    }
    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Uploading photo {}", photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

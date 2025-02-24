package school.faang.naughtwoBJS261877;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();

    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            checkPhotoPath(photoPath);
            addPhotosToUpload(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photoPath : photosToUpload) {
                log.info("Photo {} uploaded to the server.", photoPath);
            }
            photosToUpload.clear();
        }
    }

    private void addPhotosToUpload(String photoPath) {
        if (!photosToUpload.contains(photoPath)) {
            photosToUpload.add(photoPath);
            log.info("Photo path {} added to boot list.", photoPath);
        } else {
            log.info("Photo path {} is already in the boot list.", photoPath);
        }
    }

    private void checkPhotoPath(String photoPath) {
        if (photoPath == null || photoPath.isBlank()) {
            throw new IllegalArgumentException("Photo path cannot be 'null' or empty");
        }
    }
}


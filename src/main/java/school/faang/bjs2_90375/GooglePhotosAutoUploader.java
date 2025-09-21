package school.faang.bjs2_90375;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean flag = false;

    public void onNewPhotoAdded(String photoPath) {
        if (Objects.nonNull(photoPath) && !photoPath.isBlank()) {
            synchronized (lock) {
                photosToUpload.add(photoPath);
                flag = true;
                log.info("This path {} has been added to the list", photoPath);
                lock.notify();
            }
        } else {
            log.error("The path {} passed is null or not found", photoPath);
            throw new IllegalArgumentException();
        }
    }

    public void startAutoUpload() {

        synchronized (lock) {
            while (flag) {
                try {
                    log.info("The photo upload sheet is empty. The stream has been set to wait.");
                    lock.wait();
                    uploadPhotos();
                    log.info("The stream started loading photos from the sheet {}", photosToUpload);
                } catch (InterruptedException e) {
                    log.error("interrupted photo upload", e);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(str -> log.info("Photo by path {} added to the server", str));
            photosToUpload.clear();
            flag = false;
        }
    }
}

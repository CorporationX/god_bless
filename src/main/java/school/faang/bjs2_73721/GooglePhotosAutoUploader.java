package school.faang.bjs2_73721;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    public static final Object LOCK = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (LOCK) {
            if (photosToUpload.isEmpty()) {
                try {
                    LOCK.wait(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            log.info("Added new image -> {}", photoPath);
            photosToUpload.add(photoPath);
            LOCK.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Uploaded new image ({}) to server", photo));
        photosToUpload.clear();
    }


}

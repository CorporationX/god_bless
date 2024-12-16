package school.faang.sprint3.task48900;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    private void uploadPhotos() {
        for (String s : photosToUpload) {
            log.info("Photo " + s + " uploaded to server");
        }
        photosToUpload.clear();
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            } else {
                photosToUpload.wait();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            log.info("Photo " + photoPath + " was added");
            photosToUpload.notify();
        }
    }
}

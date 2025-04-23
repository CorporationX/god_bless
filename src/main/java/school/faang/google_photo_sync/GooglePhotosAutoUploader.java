package school.faang.google_photo_sync;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            for (String photo : photosToUpload) {
                log.info("Фотография {} загружена", photo);
            }
            photosToUpload.clear();
        }
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }
}

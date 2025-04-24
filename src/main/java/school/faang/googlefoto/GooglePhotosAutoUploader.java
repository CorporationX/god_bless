package school.faang.googlefoto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    log.info("wait");
                } catch (InterruptedException e) {
                    log.error("поток прерван", e);
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos();
            startAutoUpload();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Фото: {} добавлено", photoPath);
            lock.notify();
            log.info("notify");
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach((f) -> {
                log.info("Фото: {} загружено", f);
            });
            photosToUpload.clear();
        }
    }
}

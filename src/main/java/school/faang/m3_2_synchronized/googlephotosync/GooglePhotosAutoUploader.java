package school.faang.m3_2_synchronized.googlephotosync;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                log.info("Жду фотографии для загрузки");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Появились новые фотографии для загрузки на сервер");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.clear();
        log.info("Фотографии загружены на сервер");
    }
}

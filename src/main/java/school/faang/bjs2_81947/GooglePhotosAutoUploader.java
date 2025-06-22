package school.faang.bjs2_81947;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("поток загрузки фотографий прерван");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("фотография добавлена {}", photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("фотография загружена {}", photo);
        }
        photosToUpload.clear();
    }
}

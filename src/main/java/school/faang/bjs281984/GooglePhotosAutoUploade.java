package school.faang.bjs281984;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploade {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void uploadPhotos() {
        for (int i = 0; i < photosToUpload.size(); i++) {
            photosToUpload.remove(i);
            log.info("Фото добавлено");
        }
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (!photosToUpload.isEmpty() || photosToUpload.isEmpty()) {
                lock.wait();
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

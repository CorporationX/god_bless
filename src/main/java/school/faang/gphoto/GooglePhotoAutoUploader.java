package school.faang.gphoto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Data
public class GooglePhotoAutoUploader {
    private final int timeout = 1000;
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    log.info("Нет фотографий для загрузки");
                    lock.wait(timeout);
                } catch (InterruptedException e) {
                    throw new InterruptedException();
                }
            }
            uploadPhotos();
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                log.info("Фото загружено на сервер {}", photo);
            }
            photosToUpload.clear();
            lock.notify();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

}

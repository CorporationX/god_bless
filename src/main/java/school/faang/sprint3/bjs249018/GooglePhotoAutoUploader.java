package school.faang.sprint3.bjs249018;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>(List.of("C:/photos/001.jpg", "C:/photos/002.jpg"));

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Ошибка при ожидании потока: ", e);
                } catch (Exception e) {
                    log.error("Непредвиденная ошибка: ", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Фото '{}' было добавлено на устройство.", photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                log.info("Фото '{}' загружено.", photo);
            }
            log.info("Все фотографии успешно загружены на сервер.");
            photosToUpload.clear();
            log.info("Фотографии удалены с устройства.\n");
        }
    }
}
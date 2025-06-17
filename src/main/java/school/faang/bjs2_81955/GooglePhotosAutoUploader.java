package school.faang.bjs2_81955;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            try {
                if (photosToUpload.isEmpty()) {
                    log.info("Отсутствуют фото для загрузки. Ожидаем");
                    photosToUpload.wait();
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                log.error("Поток был прерван", e);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            log.info("Доступно фото для загрузки");
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            log.info("Фото загружены на сервер");
            photosToUpload.clear();
        }
    }
}

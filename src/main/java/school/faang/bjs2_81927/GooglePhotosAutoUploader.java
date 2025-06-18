package school.faang.bjs2_81927;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpdate() {
        synchronized (photosToUpload) {
            try {
                if (photosToUpload.isEmpty()) {
                    photosToUpload.wait();
                    log.info("Ожидаем фото для загрузки...");
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                log.warn("Поток был прерван во время ожидания", e);
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
        try {
            log.info("Процесс загрузки фото...");
            photosToUpload.clear();
            log.info("Загрузка завершена");
        } catch (Exception e) {
            log.error("Ошибка при загрузке фото", e);
        }
    }

}

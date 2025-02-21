package school.faang.BJS2_61740;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("Новых фотографий нет");
                    photosToUpload.wait();
                    uploadPhotos();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (photosToUpload) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload.add(photoPath);
            log.info("Фотографии добавлены в библиотеку и готовы для загрузки на сервер");
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (photosToUpload) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Фотографии загружены на сервер");
            photosToUpload.clear();
        }
    }
}

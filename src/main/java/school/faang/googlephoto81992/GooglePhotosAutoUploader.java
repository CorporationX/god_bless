package school.faang.googlephoto81992;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("фотографий готовых к загрузке нет");
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Поток прерван");
                    }
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos()  {
        for (String photo : photosToUpload) {
            log.info("Фото с адресом {} загружено на сайт", photo);
        }
        photosToUpload.clear();
    }
}



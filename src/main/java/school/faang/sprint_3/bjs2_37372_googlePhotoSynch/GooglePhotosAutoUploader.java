package school.faang.sprint_3.bjs2_37372_googlePhotoSynch;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    public static final int MAX_WAIT_TIME = 5000;
    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private volatile boolean stopRequested = false;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = new ArrayList<>(photosToUpload);
    }

    public void startAutoUpload() {
        while (!stopRequested) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait(MAX_WAIT_TIME);
                    } catch (InterruptedException e) {
                        log.error("Произошла ошибка при ожидании добавления фото в список для загрузки.", e);
                        throw new RuntimeException(e);
                    }
                }

                if (photosToUpload.isEmpty()) {
                    log.info("Фото не добавлены в список для загрузки в течение {} сек., завершаем работу.",
                            MAX_WAIT_TIME / 1000);
                    stopRequested = true;
                }

                if (!stopRequested) {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография в список загрузки {}. ", photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Фотография загружена  {}.", photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Произошла ошибка во время задержки потока", e);
                throw new RuntimeException(e);
            }
        }
        photosToUpload.clear();
    }
}

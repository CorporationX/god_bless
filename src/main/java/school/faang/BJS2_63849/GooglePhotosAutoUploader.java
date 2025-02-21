package school.faang.BJS2_63849;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
    private static volatile boolean isLast = false;
    private static final List<String> photosToUpload = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && !isLast) {
                    logger.info("Нет фото для загрузки. Ожидание...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        logger.error("Призошла ошибка в startAutoUpload", e);
                        return;
                    }
                }

                if (photosToUpload.isEmpty() && isLast) {
                    logger.info("Завершение работы загрузчика.");
                    return;
                }

                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            if (!photosToUpload.isEmpty()) {
                String photo = photosToUpload.remove(0);
                logger.info("Фотография '{}' загружена на сервер", photo);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath, boolean isEnd) {
        Objects.requireNonNull(photoPath, "photoPath can't be null");

        synchronized (lock) {
            photosToUpload.add(photoPath);
            isLast = isEnd;
            logger.info("Добавлена новая фотография '{}'", photoPath);
            lock.notify();
        }
    }
}

package faang.school.godbless.task.multithreading.google.photo.sync;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {
    private final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Lock lock;
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        logger.info("Начата автозагрузка фотографий в облако");
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    logger.info("Список фотографий пуст, автозагрузка приостановлена");
                    try {
                        lock.wait();
                    } catch (InterruptedException exception) {
                        logger.error("Interrupted exception: {}", exception.getMessage());
                    }
                } else {
                    logger.info("В списке новые фото, автозагрузка возобновлена");
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            logger.info("В список добавлено фото: {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            logger.info("Фото {} загружено в облако", photo);
        });
        photosToUpload.clear();
    }
}

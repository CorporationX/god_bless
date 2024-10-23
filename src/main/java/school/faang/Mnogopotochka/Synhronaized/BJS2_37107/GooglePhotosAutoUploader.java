package school.faang.Mnogopotochka.Synhronaized.BJS2_37107;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger log = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private Server server = new Server();
    private boolean isRunning = true;

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (isRunning || !photosToUpload.isEmpty()) {
                if (photosToUpload.isEmpty()) {
                    log.info("{} в ожидании новых данных", Thread.currentThread().getName());
                    lock.wait();
                } else {
                    List<String> pathList = new ArrayList<>(photosToUpload);
                    log.info("Загрузка данных на сервер");
                    pathList.forEach(path -> {
                        uploadPhoto(path);
                        log.info("Загружено: {}", path);
                    });
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            log.warn("Путь к фотографии не может быть пустым или null");
            return;
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография: {}", photoPath);
            lock.notify();
        }
    }

    public void uploadPhoto(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            log.warn("Путь к фотографии не может быть пустым или null");
            return;
        }
        server.getPhotos().add(photoPath);
        photosToUpload.remove(photoPath);
        log.info("Фотография загружена и удалена: {}", photoPath);
    }
}

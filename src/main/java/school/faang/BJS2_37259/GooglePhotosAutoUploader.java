package school.faang.BJS2_37259;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {

    private static final Logger log = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();

    @Getter
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUploader() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    log.info("Нет фото для загрузки. Ожидание...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Произошла ошибка при ожидании фото",e);
                        Thread.currentThread().interrupt();
                    }
                }
                uploadPhoto();
            }
        }
    }

    public void onNewPhoto(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотка: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhoto() {
        for (String photo : photosToUpload) {
            log.info("Загружаю фото: " + photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Произошла ошибка при загрузке фото",e);
            }
        }
        photosToUpload.clear();
        log.info("Загрузка фото завершена");
    }
}

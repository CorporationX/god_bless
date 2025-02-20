package school.faang.sprint3.bjs2_61723;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> urls = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                if (urls.isEmpty()) {
                    log.info("Фотографии для выгрузки отсутствуют, ожидаем...");
                    lock.wait();
                }
            } catch (InterruptedException e) {
                log.error("Поток был прерван", e);
                Thread.currentThread().interrupt();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        for (int i = 0; i < 3; i++) {
            synchronized (lock) {
                urls.add(photoPath);
                log.info(String.format("Фотография добавлена: %s", photoPath));
                lock.notify();
            }
        }
    }

    private void uploadPhotos() {
        for (Iterator<String> iterator = urls.iterator(); iterator.hasNext(); ) {
            String photo = iterator.next();
            log.info(String.format("Выгрузка фотографии: %s ", photo));
            iterator.remove();
        }
    }
}

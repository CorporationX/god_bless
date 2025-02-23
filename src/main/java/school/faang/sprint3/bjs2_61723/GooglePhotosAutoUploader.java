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
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                try {
                    while (urls.isEmpty()) {
                        log.info("Фотографии для выгрузки отсутствуют, ожидаем...");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    log.error("Поток был прерван", e);
                    Thread.currentThread().interrupt();
                    break;
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            urls.add(photoPath);
            log.info("Фотография добавлена: {}", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (Iterator<String> iterator = urls.iterator(); iterator.hasNext(); ) {
            String photoPath = iterator.next();
            log.info("Выгрузка фотографии: {} ", photoPath);
            iterator.remove();
        }
    }
}

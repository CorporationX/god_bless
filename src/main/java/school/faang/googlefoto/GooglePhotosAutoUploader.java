package school.faang.googlefoto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final Deque<String> photosToUpload = new ArrayDeque<>();

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (lock) {
                    if (photosToUpload.isEmpty()) {
                        log.info("Проверяем папку на пустоту");
                        lock.wait();
                        log.info("Поток заснул");
                    }
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                log.error("поток прерван исключением", e);
                Thread.currentThread().interrupt();
                log.error("Восстанавливаем флаг прерывания, для завершения цикла");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Фото: {} добавлено", photoPath);
            lock.notify();
            log.info("Отправили сигнал на пробуждение другим потокам");
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            log.error("Процесс добавления фото в папку прерван", e);
        }
    }

    public void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            String foto = photosToUpload.poll();
            log.info("Фото: {} загружено", foto);
        }
        Thread.sleep(200);
    }
}
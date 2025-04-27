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
    boolean applicationStates = false;

    public void managementProgram() {
        applicationStates = !applicationStates;
        log.info("Состояние программы изменено на: {}", applicationStates);
    }

    public void startAutoUpload() {
        do {
            synchronized (lock) {
                try {
                    if (photosToUpload.isEmpty()) {
                        log.info("Поток заснул");
                        lock.wait(1000);
                        log.info("Поток проснулся");
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    log.error("поток прерван исключением", e);
                    Thread.currentThread().interrupt();
                }
            }
        } while (applicationStates);
        log.info("Программа остановлена");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Фото: {} добавлено в список", photoPath);
            lock.notify();
            log.info("Отправили сигнал на пробуждение другим потокам");
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            log.error("Поток прерван");
        }
    }

    public void uploadPhotos() throws InterruptedException {
        for (String photo : photosToUpload) {
            log.info("Фото: {} загружено", photo);
            Thread.sleep(300);
        }
        photosToUpload.clear();
        log.info("Папка пустая");
    }
}
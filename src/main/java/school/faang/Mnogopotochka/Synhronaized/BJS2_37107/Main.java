package school.faang.Mnogopotochka.Synhronaized.BJS2_37107;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    static GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

    public static void main(String[] args) {
        Thread uploadPhotoPath = new Thread(() -> {
            try {
                log.info("Запуск потока загрузки фотографий");
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.warn("Поток загрузки фотографий прерван", e);
            }
        });

        Thread addNewPhoto = new Thread(() -> {
            try {
                log.info("Запуск потока добавления новых фотографий");
                addPhotoPath();
            } catch (InterruptedException e) {
                log.warn("Поток добавления новых фотографий прерван", e);
            }
        });

        uploadPhotoPath.start();
        addNewPhoto.start();

        try {
            uploadPhotoPath.join();
            addNewPhoto.join();
        } catch (InterruptedException e) {
            log.warn("Главный поток прерван", e);
        }

        log.info("Все потоки завершены");
    }

    private static void addPhotoPath() throws InterruptedException {
        for (int i = 1; i <= 32; i++) {
            String photoPath = "path/to/photo" + i + ".jpg";
            googlePhotosAutoUploader.onNewPhotoAdded(photoPath);
        }
    }
}

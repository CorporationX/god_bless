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
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo1.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo2.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo3.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo4.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo5.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo6.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo7.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo8.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo9.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo10.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo11.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo12.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo13.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo14.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo15.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo16.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo17.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo18.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo19.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo20.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo21.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo22.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo23.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo24.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo25.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo26.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo27.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo28.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo29.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo30.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo31.jpg");
        googlePhotosAutoUploader.onNewPhotoAdded("path/to/photo32.jpg");
    }
}

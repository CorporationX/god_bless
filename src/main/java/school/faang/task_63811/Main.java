package school.faang.task_63811;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int SHORT_DELAY = 1000;
    private static final int LONG_DELAY = 2000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(SHORT_DELAY);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(LONG_DELAY);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Добавление фотографий прервано: {}", e.getMessage());
            } finally {
                uploader.stopAutoUpload();
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            uploadThread.join();
            addPhotosThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка ожидания завершения потоков: {}", e.getMessage());
        }
    }
}

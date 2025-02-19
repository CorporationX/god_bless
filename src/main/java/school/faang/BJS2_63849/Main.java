package school.faang.BJS2_63849;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Logger logger = LoggerFactory.getLogger(Main.class);

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        uploadThread.start();

        Thread addPhotosThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                googlePhotosAutoUploader.onNewPhotoAdded("Winter.jpg", false);

                Thread.sleep(1000);
                googlePhotosAutoUploader.onNewPhotoAdded("Summer.jpg", false);

                Thread.sleep(1000);
                googlePhotosAutoUploader.onNewPhotoAdded("Autumn.jpg", true);

            } catch (InterruptedException e) {
                logger.error("Призошла ошибка в {}", Thread.currentThread().getName(), e);
                Thread.currentThread().interrupt();
            }
        });

        addPhotosThread.start();
        addPhotosThread.join();

        uploadThread.join();
    }
}

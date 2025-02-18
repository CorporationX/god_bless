package school.faang.googlephoto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            uploader.onNewPhotoAdded("path1");
            uploader.onNewPhotoAdded("path2");
        });
        Thread addPhotosThread = new Thread(uploader::startAutoUpload);

        addPhotosThread.start();
        uploadThread.start();

        try {
            uploadThread.join();
            addPhotosThread.join();
        } catch (InterruptedException e) {
            LOGGER.error("Поток был прерван, при выполнении join: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

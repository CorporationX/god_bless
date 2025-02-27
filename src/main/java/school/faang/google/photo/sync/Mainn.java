package school.faang.google.photo.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainn {
    private static final Logger logger = Logger.getLogger(Mainn.class.getName());

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Поток был прерван");
                Thread.currentThread().interrupt();
            }
        });

        uploadThread.start();
        addPhotoThread.start();
    }
}
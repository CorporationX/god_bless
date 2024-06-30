package faang.school.godbless.BJS212666;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("picture1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("picture2.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("picture3.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("picture4.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted while tried to add new Photo", e);
            } finally {
                uploader.turnOf();
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            uploadThread.join();
            addPhotosThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted while tried to join to main Thread", e);
        }
    }
}

package school.faang.bjs2_82023;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(uploader::startAutoUploader);
        uploaderThread.setName("UploaderThread");

        Thread producerThread = new Thread(() -> {
            AtomicInteger photoCounter = new AtomicInteger(1);
            try {
                while (true) {
                    String photoPath = "photo_" + photoCounter.getAndIncrement() + ".jpg";
                    System.out.println("Adding new photo: " + photoPath);
                    uploader.onNewPhotoAdded(photoPath);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producerThread.setName("ProducerThread");

        uploaderThread.start();
        producerThread.start();

        try {
            uploaderThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
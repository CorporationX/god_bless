package school.faang.bjs2_90468;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(uploader::startAutoUpload, "UploaderThread");

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(2000);
                    uploader.onNewPhotoAdded("photo_" + i + ".jpg");
                }

                Thread.sleep(4000);
                uploader.onNewPhotoAdded("photo_extra_1.jpg");
                uploader.onNewPhotoAdded("photo_extra_2.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "ProducerThread");

        uploaderThread.start();
        producerThread.start();

        producerThread.join();
        Thread.sleep(8000);

        uploaderThread.interrupt();
        uploaderThread.join();

        log.info("Program is complete...");
    }
}

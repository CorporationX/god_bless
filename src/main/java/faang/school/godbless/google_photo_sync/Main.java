package faang.school.godbless.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread threadToRead = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread threadToWrite1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("test1"));
        Thread threadToWrite2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("test2"));
        Thread threadToWrite3 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("test3"));
        Thread threadToWrite4 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("test4"));
        Thread threadToWrite5 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("test5"));

        threadToRead.start();
        Thread.sleep(2000);
        threadToWrite1.start();
        Thread.sleep(2000);
        threadToWrite2.start();
        Thread.sleep(2000);
        threadToWrite3.start();
        Thread.sleep(2000);
        threadToWrite4.start();
        Thread.sleep(2000);
        threadToWrite5.start();

        try {
            threadToWrite1.join();
            threadToWrite2.join();
            threadToWrite3.join();
            threadToWrite4.join();
            threadToWrite5.join();

            threadToRead.interrupt();
        } catch (RuntimeException ex) {
            log.info(ex.getMessage());
        }
    }
}
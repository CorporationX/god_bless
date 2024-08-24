package BJS2_24401_GooglePhotoSync;

import java.util.concurrent.CountDownLatch;

public class Application {
    private static final int PHOTO_TO_UPLOAD = 10;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        CountDownLatch cdl = new CountDownLatch(PHOTO_TO_UPLOAD);
        Thread getPhotos = new Thread(() -> {
            for (int i = 0; i < PHOTO_TO_UPLOAD; i++) {
                try {
                    Thread.sleep(1000);
                    googlePhotosAutoUploader.onNewPhotoAdded("photo " + (i + 1));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                cdl.countDown();
            }
        });
        uploadThread.start();
        getPhotos.start();

        try {
            cdl.await();
            uploadThread.interrupt();
        } catch (InterruptedException e) {
            uploadThread.interrupt();
            getPhotos.interrupt();
        }
    }
}

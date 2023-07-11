package faang.school.godbless.multithreading.synchronized_wait_notify.google_photo_sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PHOTO_THREADS_NUM = 5;

    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        uploader.initialize();

        Thread uploadThread = new Thread(() -> uploader.startAutoUpload());
        Thread viewThread = new Thread(() -> {
            try {
                for (int i = 0; i < PHOTO_THREADS_NUM; i++) {
                    Thread.sleep(1000);
                    uploader.onNewPhotoAdded("path " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        viewThread.start();

    }
}

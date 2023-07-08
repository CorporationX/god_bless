package faang.school.godbless.multithreading.synchronized_wait_notify.google_photo_sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PHOTO_THREADS_NUM = 10;

    public static void main(String[] args) {

//        Photo photo1 = new Photo("name1", "path1", 5);
//        Photo photo2 = new Photo("name2", "path2", 6);
        GooglePhoto googlePhoto = new GooglePhoto();

        ExecutorService executor = Executors.newFixedThreadPool(PHOTO_THREADS_NUM);
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        uploader.initialize();

        Thread uploaderThread = new Thread(() -> uploader.startAutoUpload());
        uploaderThread.start();

        System.out.println("log 1");

        for (int i = 0; i < PHOTO_THREADS_NUM; i++) {
            int pathIndex = i;
            executor.execute(() -> googlePhoto.addPhoto(new Photo("photo " + pathIndex, "/path/" + pathIndex)));
        }

        executor.shutdown();

//        GooglePhoto googlePhoto = new GooglePhoto();
//
//        Thread thread1 = new Thread(() -> googlePhoto.addPhoto(photo1));
//
//        thread1.start();

//        while (true) {
//            uploader.startAutoUpload();
//        }

    }
}

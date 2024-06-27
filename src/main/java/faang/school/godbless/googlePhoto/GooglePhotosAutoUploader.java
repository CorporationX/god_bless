package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GooglePhotosAutoUploader {
    private static Object lock = new Object();
    private static boolean isRunning;
    private static List<Photo> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        Photo photo = new Photo("123");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                executor.submit(GooglePhotosAutoUploader::startAutoUpload);
            } else {
                executor.submit(() -> onNewPhotoAdded(photo));
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopAutoUpload();
        executor.shutdown();
    }

    public static void startAutoUpload() {
        if (!isRunning) {
            isRunning = true;
        }

        synchronized (lock) {
            while (isRunning) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted while waiting for auto upload", e);
                    }
                }

                if (!photosToUpload.isEmpty()) {
                    uploadPhotos(photosToUpload.get(0));
                    System.out.println("Auto upload complete");
                } else {
                    System.out.println("Auto upload stopped");
                }
            }
        }
    }

    public static void onNewPhotoAdded(Photo photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
            lock.notify();
        }
    }

    private static void uploadPhotos(Photo photo) {
        System.out.println("Uploading photos to google");
        photosToUpload.remove(photo);
    }

    public static void stopAutoUpload() {
        synchronized (lock) {
            if (isRunning) {
                isRunning = false;
                lock.notify();
            }
        }
    }
}

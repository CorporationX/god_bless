package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread adderThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread uploaderThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });

        adderThread.start();
        uploaderThread.start();
    }


    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("В ожидании новых фотографий");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            while (!photosToUpload.isEmpty()) {
                String photo = photosToUpload.remove(0);
                System.out.println("Фотография загружена: " + photo);
            }
        }
    }
}

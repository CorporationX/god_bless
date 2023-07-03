package Multithreading;

import Multithreading.bc2765.GooglePhotosAutoUploader;

public class Application {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread threadToAdded = new Thread(() -> {
            googlePhoto.oneNewPhotoAdded("Some photo1");
            googlePhoto.oneNewPhotoAdded("Some photo2");
            googlePhoto.oneNewPhotoAdded("Some photo3");
            googlePhoto.oneNewPhotoAdded("Some photo4");
            googlePhoto.oneNewPhotoAdded("Some photo5");
            try {
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadStartToUpload = new Thread(() -> {
            try {
                Thread.sleep(1000);
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadToAdded.start();
        threadStartToUpload.start();
    }
}

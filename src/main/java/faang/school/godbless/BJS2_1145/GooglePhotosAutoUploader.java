package faang.school.godbless.BJS2_1145;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    public static void main(String[] args) {
        List<String> photosToUpload = new ArrayList<>();
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(photosToUpload);

        Thread uploadPhoto = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path to Photo"));
        Thread viewPhoto = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());

        uploadPhoto.start();
        viewPhoto.start();


    }
    private Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("error in waiting");
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Path of photo added");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Photo uploaded to Google Photos");
        photosToUpload.clear();
    }

}

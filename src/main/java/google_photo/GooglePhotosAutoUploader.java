package google_photo;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
        }
        uploadPhotos();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (var photo : photosToUpload) {
            System.out.println("загружает фотографии?");
        }
        photosToUpload.clear();
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = new ArrayList<>();
        photos.add("photoPath");
        photos.add("nicePath");
        photos.add("badPath");

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        for (String photo : photos) {
            Thread photoAdd = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(photo));
            photoAdd.start();
        }
        uploadThread.start();
    }
}
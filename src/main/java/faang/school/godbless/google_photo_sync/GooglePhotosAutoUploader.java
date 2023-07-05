package faang.school.godbless.google_photo_sync;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for(int i = 0; i < photosToUpload.size(); i++) {
            System.out.println("Photo from " + photosToUpload.get(i) + " was uploaded to Google Photos");
            photosToUpload.remove(i);
        }
        System.out.println("All photos uploaded!");
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> photos = new ArrayList<>();
        for(int i = 0; i < 200; i++) {
            photos.add("photoPath" + i);
        }

        Thread forUpload = new Thread(autoUploader :: startAutoUpload);
        for(String photo : photos) {
            Thread photosAdd = new Thread(() -> autoUploader.oneNewPhotoAdded(photo));
            photosAdd.start();
        }
        forUpload.start();
    }
}

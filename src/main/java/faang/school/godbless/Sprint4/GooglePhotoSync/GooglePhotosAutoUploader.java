package faang.school.godbless.Sprint4.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photoPath);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded (String photoPath){
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread watchThread = new Thread(() -> {
            uploader.onNewPhotoAdded("C:/photos/photo1.jpg");
            uploader.onNewPhotoAdded("C:/photos/photo2.jpg");
        });

        uploadThread.start();
        watchThread.start();
    }
}

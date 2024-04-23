package BJS2_5962;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Фото успешно загружено");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

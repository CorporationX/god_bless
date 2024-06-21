package faang.school.godbless.BJS2_12767;


import java.util.ArrayList;
import java.util.List;


public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    void startAutoUpload() {
        while (true) {
            if (photosToUpload.isEmpty()) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else uploadPhotos();
        }
    }

    void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    void uploadPhotos() {
        System.out.println("Загружаю фотографию на сервер Google Photos");
        photosToUpload.clear();
    }
}


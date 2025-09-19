package school.faang.multithreading.sinchronized.bjs2_90384;

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
                    e.printStackTrace();
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
        photosToUpload.stream()
                .forEach(photo ->
                        System.out.printf("Фотография '%s' на сервер загружена\n", photo));
        photosToUpload.clear();
    }
}

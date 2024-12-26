package school.faang.task_49111;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        synchronized (lock) {
            while (!photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    uploadPhotos();
                } catch (InterruptedException e) {
                    System.out.println("!!!Exception!!! " + e);
                    Thread.currentThread().interrupt();
                    return;
                }
            }

        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Загружено Фото " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(s -> System.out.println("Photos from " + s + " is upload"));
        photosToUpload.clear();
    }


}

package school.faang.multithreading.synchronize.bjs2_90441;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Фотографии добавлены в список");
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            System.out.println("Фотографии загружены на сервер");
            photosToUpload.clear();
        }
    }
}
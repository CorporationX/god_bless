package school.faang.bjs2_73863;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();

    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Время ожидания истекло");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> System.out.printf("Uploading photos, %s", photo));
            photosToUpload.clear();
        }
    }
}

package school.faang.sprint3.task_BJS2_61999;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        if (photosToUpload.isEmpty()) {
            waiting();
        }
        uploadPhotos();
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notify();
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Фото %s загружено\n", photo));
        photosToUpload.clear();
    }

    private void waiting() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

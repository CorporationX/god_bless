package school.faang.task_49077;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isRunning = true;

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    if (!isRunning) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                uploadPhotos();
            }
        }
        System.out.println("Загрузка завершена.");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            isRunning = false;
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Загружается: " + photo));
        photosToUpload.clear();
    }
}
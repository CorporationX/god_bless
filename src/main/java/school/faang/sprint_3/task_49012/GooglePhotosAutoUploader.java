package school.faang.sprint_3.task_49012;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Ожидаем новое фото");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Загружаем новое фото %s%n", photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Добавление новой фотографиии");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

package school.BJS2_37135;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Список для отправки пуст. Нужно подождать.");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (lock) {
            System.out.println("Добавляем фото " + photo);
            photosToUpload.add(photo);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.stream().forEach(photo -> {
            System.out.printf("Отправляю фото %s на сервер.", photo);
            System.out.println();
        });
        photosToUpload.clear();
    }
}

package school.faang.BJS2_37296;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Нет фотографий для загрузки. Ожидание...");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток загрузки был прерван.");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Начинается загрузка фотографий...");
            for (String photo : photosToUpload) {
                System.out.println("Загружается: " + photo);
            }
            photosToUpload.clear();
            System.out.println("Все фотографии загружены.");
        }
    }
}

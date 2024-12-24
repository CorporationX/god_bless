package school.faang.task_48975;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    protected void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("Нет новых фотографий. Ожидание...");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток загрузки прерван.");
                    break;
                }
            }
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
                System.out.println("Загрузка: " + photo);
                try {
                    Thread.sleep(1000); // Имитация времени загрузки
                } catch (InterruptedException e) {
                    System.out.println("Поток загрузки прерван.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            photosToUpload.clear();
            System.out.println("Загрузка завершена.");
        }
    }
}

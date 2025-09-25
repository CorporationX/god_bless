package school.faang.bjs292467;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        // Ждем, пока не появятся новые фотографии
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                // Загружаем фотографии
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            // Уведомляем ожидающий поток о появлении новых фотографий
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            // Имитация загрузки фотографии
            System.out.println("Загружаю фотографию: " + photoPath);
        }
        // Очищаем список после загрузки
        photosToUpload.clear();
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        // Поток для автоматической загрузки фотографий
        Thread uploadThread = new Thread(uploader::startAutoUpload);

        // Поток для добавления новых фотографий
        Thread addPhotoThread = new Thread(() -> {
            try {
                // Добавляем фотографии через некоторое время
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Запуск потоков
        uploadThread.start();
        addPhotoThread.start();
    }
}
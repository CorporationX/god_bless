package tasks.bjs2_37214;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploadService = new GooglePhotosAutoUploader();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(uploadService::startAutoUpload, 100, TimeUnit.MILLISECONDS);
        scheduler.schedule(uploadService::emulationAddingPhotos, 100, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Фото добавлено в очередь : " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait(5_000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("В процессе ожидания данных, произошла ошибка : " + e.getMessage());
                }

                if(photosToUpload.isEmpty()) {
                    System.out.println("Все фото загружены!");
                    break;
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    private void emulationAddingPhotos() {
        onNewPhotoAdded("https://example.com/image1.jpg");
        onNewPhotoAdded("https://example.com/image2.jpg");
        onNewPhotoAdded("https://example.com/image3.jpg");
        onNewPhotoAdded("https://example.com/image4.jpg");
        onNewPhotoAdded("https://example.com/image5.jpg");
        onNewPhotoAdded("https://example.com/image6.jpg");
        onNewPhotoAdded("https://example.com/image7.jpg");
        onNewPhotoAdded("https://example.com/image8.jpg");
        onNewPhotoAdded("https://example.com/image9.jpg");
        onNewPhotoAdded("https://example.com/image10.jpg");
    }

    private void uploadPhotos() {
        System.out.println("Загружаем фотографии на сервер...");
        photosToUpload.forEach(System.out::println);
        System.out.println("Загрузка завершена.");
        photosToUpload.clear();
    }
}

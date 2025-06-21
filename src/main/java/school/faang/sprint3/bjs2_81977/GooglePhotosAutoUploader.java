package school.faang.sprint3.bjs2_81977;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    private void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                try {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Нет файлов, ожидание");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                uploadPhotos();
            }
        }
    }

    private void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлен файл в очередь на загрузку в Google Photos");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("Добавлено изображение в Google Photos: " + next);
            iterator.remove();
        }
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(uploader::startAutoUpload);
        executor.execute(() -> {
            uploader.onNewPhotoAdded("img1.png");
            uploader.onNewPhotoAdded("img2.png");
            uploader.onNewPhotoAdded("img3.png");
        });

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

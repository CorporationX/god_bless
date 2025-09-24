package school.faang.m1.thread.google.photo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglePhotosAutoUploader {
    final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("[Uploader] Нет новых фотографий. Ожидание...");
                        lock.wait(); // Ждем пока появятся новые фото
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("[Uploader] Поток прерван.");
                        return;
                    }
                }
                uploadPhotos(); // Загружаем фото, если они есть
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : new ArrayList<>(photosToUpload)) {
                System.out.printf("[Uploader] фото загружено: [%s]" + System.lineSeparator(), photo);
                photosToUpload.remove(photo);
            }
        }
    }

    private void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("[Adder] Новое фото добавлено: " + photoPath);
            lock.notify(); // Уведомляем ждущий поток
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread writer = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    Thread.sleep(1000);
                    uploader.onNewPhotoAdded("photo" + i + ".jpg");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread reader = new Thread(uploader::startAutoUpload);

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}

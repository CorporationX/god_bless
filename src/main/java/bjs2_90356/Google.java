package bjs2_90356;

import java.util.*;

public class Google {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean running = true; // чтобы можно было завершить работу (опционально)

    // Запускаем бесконечный цикл авто-загрузки
    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Нет новых фотографий. Ждём...");
                        lock.wait(); // ждём появления новых фотографий
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    // Добавляем фото
    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Новая фотография добавлена: " + photoPath);
            lock.notify(); // разбудим поток загрузки
        }
    }

    // Загружаем фото
    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
            try {
                Thread.sleep(500); // имитация загрузки
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Фотография " + photo + " загружена!");
        }
        photosToUpload.clear();
    }

    public void stop() {
        running = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Google uploader = new Google();

        // Поток для загрузки
        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");

        // Поток, который добавляет фото
        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo3.jpg");
                Thread.sleep(1000);
                uploader.stop(); // останавливаем приложение
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "PhotoAdderThread");

        uploadThread.start();
        photoAdderThread.start();
    }
}
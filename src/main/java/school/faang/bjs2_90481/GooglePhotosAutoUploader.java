package school.faang.bjs2_90481;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private volatile boolean running = true;

    public void startAutoUpload() {
        while (running) {
            List<String> batch;
            synchronized (lock) {
                while (photosToUpload.isEmpty() && running) {
                    try {
                        System.out.println("Жду новые фото...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        running = false;
                    }
                }
                if (!running) {
                    break;
                }
                batch = new ArrayList<>(photosToUpload);
                photosToUpload.clear();
            }
            uploadPhotos(batch);
            System.out.println("[" + Thread.currentThread().getName() + "]"
                    + " Получено: " + batch.size() + " фото " + batch);
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Остановлен");
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            throw new IllegalArgumentException("Путь к фото не должен быть null или пустым");
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
            System.out.println("[" + Thread.currentThread().getName() + "]"
                    + " добавил фото " + photoPath);
        }
    }

    public void uploadPhotos(List<String> batch) {
        if (batch == null || batch.isEmpty()) {
            return;
        }

        for (String photo : batch) {
            System.out.println("Загружаю фото: " + photo);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void requestStop() {
        synchronized (lock) {
            running = false;
            lock.notifyAll();
        }
    }
}
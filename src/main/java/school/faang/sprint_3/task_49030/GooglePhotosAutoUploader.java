package school.faang.sprint_3.task_49030;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private volatile boolean running = true;

    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && running) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Поток загрузки был прерван.");
                        return;
                    }
                }
                if (!running) {
                    break;
                }

                photosToUpload.forEach(photo -> System.out.println("Загружается: " + photo));
                photosToUpload.clear();
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

    public void stop() {
        synchronized (lock) {
            running = false;
            lock.notifyAll();
        }
    }
}

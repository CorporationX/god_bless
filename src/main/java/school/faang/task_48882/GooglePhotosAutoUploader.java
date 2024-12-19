package school.faang.task_48882;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean run = true;

    public void startAutoUpload() {
        while (run) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && run) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Ждём новых фотографий...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Загрузка прервана.");
                        return;
                    }
                }
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Завершение работы.");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(Thread.currentThread().getName() + ": Добавлена фотография " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println(Thread.currentThread().getName() + ": Загружаем фотографии...");
        for (String photo : photosToUpload) {
            System.out.println(Thread.currentThread().getName() + ": Загружаем " + photo);
        }
        photosToUpload.clear();
        System.out.println(Thread.currentThread().getName() + ": Все фотографии загружены.");
    }

    public void stop() {
        synchronized (lock) {
            run = false;
            lock.notify();
        }
    }
}

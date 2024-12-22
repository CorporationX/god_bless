package school.faang.sprint3.bjs_49025;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final int DELAY = 3000;

    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток был прерван");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Выгружаем фотографии на сервер...");
        sleepThread();
        System.out.println("Фотографии загружены, очищаем список...");
        photosToUpload.clear();
        sleepThread();
        System.out.println("Список очищен!");
    }

    private void sleepThread() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }
}

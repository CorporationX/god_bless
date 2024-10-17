package school.faang.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (photosToUpload.isEmpty()) {
                        try {
                            System.out.println("Ожидание фото");
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Ошибка загрузки фото");
                        }
                    }
                    uploadPhotos();
                }
            }
        }).start();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        if (!photosToUpload.isEmpty()) {
            System.out.printf("Фото загружено...", photosToUpload.toString());
            System.out.println("");
            photosToUpload.clear();
        }
    }
}

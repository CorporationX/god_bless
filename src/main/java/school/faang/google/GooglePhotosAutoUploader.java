package school.faang.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        new Thread(() -> {
            while (true) {
                synchronized (photosToUpload) {
                    if (photosToUpload.isEmpty()) {
                        try {
                            System.out.println("Ожидание фото");
                            photosToUpload.wait();
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
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено " + photoPath);
            photosToUpload.notify();
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

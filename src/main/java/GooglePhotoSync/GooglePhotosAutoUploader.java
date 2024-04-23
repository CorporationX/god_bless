package GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object LOCK = new Object();

    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (LOCK) {
                if (photosToUpload.isEmpty()) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            LOCK.notify();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Начинаем загрузку...");
        photosToUpload.forEach(photoToUpload -> System.out.println("Фото " + photoToUpload + " загружается..."));
        photosToUpload.clear();
        System.out.println("Загрузка завершена!");
    }
}

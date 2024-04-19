package GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Начинаем загрузку...");
        photosToUpload.forEach(photoToUpload -> System.out.println("Фото " + photoToUpload + " загружается..."));
        photosToUpload.clear();
        System.out.println("Загрузка завершена!");
    }
}

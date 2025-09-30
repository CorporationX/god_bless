package school.faang.bjs2_90585;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public synchronized void startAutoUpload() {
        while (true) {
            while (photosToUpload.isEmpty()) {
                wait();
            }
            uploadPhotos();
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        notify();
    }

    private synchronized void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("Фото %s загружено на сервер.%n", photo);
        }
        photosToUpload.clear();
    }
}

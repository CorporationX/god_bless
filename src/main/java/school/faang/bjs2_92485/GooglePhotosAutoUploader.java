package school.faang.bjs2_92485;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();

    private boolean hasPhoto = false;

    public synchronized void startAutoUpload() {
        while (true) {
            while (!hasPhoto) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            uploadPhotos();
            log.info("Фото загружено");
            hasPhoto = false;
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        hasPhoto = true;
        this.notify();
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("Загружаем фото: %s%n", photo);
        }
        photosToUpload.clear();
    }
}

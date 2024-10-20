package school.faang.google.photo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        if (photosToUpload.isEmpty()) {
            System.out.println("нет фотографий для загрузки");
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
        uploadPhotos();
    }

    private synchronized void uploadPhotos() {
        System.out.println("Загружаем фотографии на сервер");
        photosToUpload.clear();
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notify();
    }
}

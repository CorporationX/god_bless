package school.faang.googlephotosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUploader() {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Список пуст. Ожидаем новые фото.");
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            while (!photosToUpload.isEmpty()) {
                uploadPhotos(photosToUpload.get(0));
            }
        }
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos(String photoPath){
        System.out.println("Загрузга фотографии : " + photoPath);
        photosToUpload.remove(photoPath);
        System.out.println("Фотография "+ photoPath + " загружена.");
    }
}

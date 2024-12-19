package school.faang.task_48886;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private static final Object LOCK = new Object();
    @Getter
    private static final List<String> photosToUpload = new ArrayList<>();

    public static void startAutoUpload() {
        synchronized (LOCK) {
            if (photosToUpload.isEmpty()) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos(photosToUpload);
        }
    }

    public static void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено в очередь на скачивание: " + photoPath + ".jpg");
            LOCK.notify();
        }
    }

    public static void uploadPhotos(List<String> photosToUpload) {
        for (String photos : photosToUpload) {
            System.out.println("Загрузка фото в облачный сервис: " + photos + ".jpg");
        }
        photosToUpload.clear();
    }
}
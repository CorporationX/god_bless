package school.faang.bjs2_90505;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait(50000);
                } catch (InterruptedException e) {
                    throw new InterruptedException("Ожидание автозагрузчика было прервано.");
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
        for (String photo : photosToUpload) {
            System.out.printf("Фото '%s' загружено.%n", photo);
        }
        photosToUpload.clear();
        System.out.println("Все фото загружены.");
    }
}
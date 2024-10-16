package school.faang.photogoogle;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();

    public void onNewPhotoAdded(String photoUrl) {
        synchronized (lock) {
            photosToUpload.add(photoUrl);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            new ArrayList<>(photosToUpload).forEach(f -> {
                System.out.printf("\n Отправка, %s", f);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                photosToUpload.remove(f);

            });
            String res = photosToUpload.isEmpty() ? "\nсписок пуст" :
                    "список непустой";
            System.out.printf(res);
        }
    }
}


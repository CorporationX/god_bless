package school.faang.task_48894;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e + " Ошибка отправки");
                        Thread.currentThread().interrupt();
                    }
                }
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Фотография " + photo + " успешно загружена на сервер!");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

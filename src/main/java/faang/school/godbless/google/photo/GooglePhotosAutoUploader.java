package faang.school.godbless.google.photo;

import lombok.Getter;

import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = List.of("Путь1", "Путь2", "Путь3");

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        System.out.println("Фото загружено");
        for (String str : photosToUpload) {
            photosToUpload.remove(str);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

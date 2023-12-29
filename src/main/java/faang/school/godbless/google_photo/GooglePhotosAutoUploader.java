package faang.school.godbless.google_photo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
            synchronized (lock) {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("ListPhotos is empty, need wait. When photos will be added.");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    uploadPhotos();
                }
            }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " добавлено");
            lock.notify();

        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println(photo + " загруженo в Google Photos");
            }
            photosToUpload.clear();
        }
    }
}

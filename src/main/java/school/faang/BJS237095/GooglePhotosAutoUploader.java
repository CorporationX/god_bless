package school.faang.BJS237095;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload.addAll(photosToUpload);
    }

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + "| Добавлена новая фотография!");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String s : photosToUpload) {
            System.out.println(s + "| Добавлен на сервер!");
        }
        photosToUpload.clear();
    }
}

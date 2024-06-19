package faang.school.godbless.GooglePhotoSync;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();

        }
    }

    private void uploadPhotos() {
        for (String path : photosToUpload) {
            System.out.println("Удалить путь к фото " + path + " " + LocalTime.now());
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлено " + photoPath + " " + LocalTime.now());
            lock.notify();
        }
    }

}

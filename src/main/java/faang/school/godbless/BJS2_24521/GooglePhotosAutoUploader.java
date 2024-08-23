package faang.school.godbless.BJS2_24521;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {

    private static List<String> photosToUpload = new ArrayList<>();

    private Object lock;

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлен путь к фото");
            lock.notify();
        }
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (int i = 0; i < photosToUpload.size(); i++) {
            photosToUpload.remove(i);
            System.out.println("Фото загружено на сервер");
            i--;
        }
    }
}

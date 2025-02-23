package school.faang.bjs2_61821;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class GooglePhotosAutoUploader {

    private final Lock lock = new ReentrantLock();

    private List<String> photosToUpload;

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload == null || photosToUpload.isEmpty()) {
                System.out.println("Фото для загрузки нет. Ожидаем");
                lock.wait(3000);
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("Фото %S добавлено в список для загрузки %n", photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println(photo + " - загружено."));
        photosToUpload = new ArrayList<>();
        System.out.println("Фото загружены. Список фотографий очищен!");
    }

}

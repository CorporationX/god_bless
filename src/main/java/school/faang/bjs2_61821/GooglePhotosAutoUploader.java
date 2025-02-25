package school.faang.bjs2_61821;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
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
        photosToUpload.clear();
        System.out.println("Фото загружены. Список фотографий очищен!");
    }

}

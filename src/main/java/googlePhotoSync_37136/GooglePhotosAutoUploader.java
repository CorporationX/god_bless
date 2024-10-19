package googlePhotoSync_37136;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Нет фотографий для загрузки. Программа в режиме ожидания...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            photosUpload();
        }
    }

    public void photosUpload() {
        synchronized (lock) {
            System.out.println("Программа пробудилась...");
            System.out.println("Фотографии в количестве " + photosToUpload.size() + " загружены.");
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография " + photoPath);
            lock.notify();
        }
    }
}






















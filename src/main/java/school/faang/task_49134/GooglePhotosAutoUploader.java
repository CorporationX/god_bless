package school.faang.task_49134;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private Set<String> photosToUpload = new HashSet<>();


    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Ожидание новых фотографий...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Поток загрузки был прерван!");
                        return;
                    }
                }
                System.out.println("Загружаем изображения!");
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлено в путь: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Загружаем фотографии: " + photosToUpload);
            photosToUpload.clear();
            System.out.println("Фотографии успешно загружены!");
        }
    }
}

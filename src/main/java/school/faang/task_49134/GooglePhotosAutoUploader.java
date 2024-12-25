package school.faang.task_49134;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private Set<String> photosToUpload = new HashSet<>();


    @SneakyThrows
    public void startAutoUpload(Set<String> pathsToPhotos) {
        synchronized (lock) {
            while (pathsToPhotos.isEmpty()) {
                lock.wait();
                System.out.println("Ждёмс так как pathsToPhotos.isEmpty()");
            }
            uploadPhotos();
            System.out.println("Вызов uploadPhotos() внутри startAutoUpload");

        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлено в путь");
            lock.notify();
            System.out.println("notified");
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Загружены на сервер");
            photosToUpload.clear();
        }
    }
}

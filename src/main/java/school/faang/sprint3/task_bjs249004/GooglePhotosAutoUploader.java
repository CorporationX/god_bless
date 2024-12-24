package school.faang.sprint3.task_bjs249004;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@ToString
@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new CopyOnWriteArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Ошибка в потоке");
                }
            }
        }
        uploadPhotos();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println("В список добавлена фотография по адресу: " + photoPath);
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            for (String photo : photosToUpload) {
                System.out.println("Добавлена фотография расположенная по адресу: " + photo);
            }
            photosToUpload.clear();
        }
    }

}

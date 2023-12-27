package faang.school.godbless.GooglePhotoSync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>(Arrays.asList("path1", "path2", "path3", "path4", "path5"));

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Добавлять нечего, ждём фото");
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photoPath : photosToUpload) {
                System.out.println("Фото " + photoPath + " загружается на сервер");

            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Сделано новое фото " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

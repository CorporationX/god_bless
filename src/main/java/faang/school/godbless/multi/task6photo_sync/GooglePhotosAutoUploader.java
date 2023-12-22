package faang.school.godbless.multi.task6photo_sync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлено фото: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        if (!photosToUpload.isEmpty()) {
            for (String photo : photosToUpload) {
                System.out.println("Загружается фото: " + photo);
                System.out.println("Загрузилось фото: " + photo);
            }
            photosToUpload.clear();
        }
    }
}

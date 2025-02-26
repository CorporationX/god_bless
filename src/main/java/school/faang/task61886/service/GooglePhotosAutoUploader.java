package school.faang.task61886.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>(Arrays.asList(
            "C:\\Users\\Pictures1",
            "C:\\Users\\Pictures2",
            "C:\\Users\\Pictures3",
            "C:\\Users\\Pictures4"
    ));

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Какая-то ошибка при загрузке: " + e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

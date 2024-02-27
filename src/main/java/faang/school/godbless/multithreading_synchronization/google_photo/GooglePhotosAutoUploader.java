package faang.school.godbless.multithreading_synchronization.google_photo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(GooglePhoto googlePhoto) {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos(googlePhoto);
            }
        }
    }

    private void uploadPhotos(GooglePhoto googlePhoto){
        System.out.println("Загружаю фото на Google Photo");
        for(String pathPhoto : photosToUpload){
            googlePhoto.getPhotoStorage().add(pathPhoto);
        }
        System.out.println("Фотографии были загружены");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock){
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено");
            lock.notify();
        }
    }

}

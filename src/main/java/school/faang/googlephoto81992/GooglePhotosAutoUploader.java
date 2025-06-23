package school.faang.googlephoto81992;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("фотографий готовых к загрузке нет");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        for (String photo : photosToUpload) {
            System.out.printf("фото с адресом %s загруженно на сайт %n", photo);
        }
        photosToUpload.clear();
    }
}

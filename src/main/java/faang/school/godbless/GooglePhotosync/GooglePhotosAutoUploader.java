package faang.school.godbless.GooglePhotosync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.size() == 0) {
                    lock.wait();
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println(photoPath + " Загружено");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            uploadPhotos();
        }
    }
}

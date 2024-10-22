package school.faang.GooglePhotoSync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    static final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock){
            if (photosToUpload.isEmpty()){
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos(){

        System.out.println("Путь: " + photosToUpload.get(0) + "\nФото загружено");
        photosToUpload.remove(0);
    }
}

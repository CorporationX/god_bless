package school.faang.googlePhoto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();



    public void startAutoUpload () {
        synchronized (lock) {
            while (photosToUpload.isEmpty()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos(){
        while (!photosToUpload.isEmpty()) {
            String photoPath = photosToUpload.remove(0);
            System.out.println("Загрузка фотографии: " + photoPath);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

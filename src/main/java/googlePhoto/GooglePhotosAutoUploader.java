package googlePhoto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            List<String> copyPhotosToUpload = new CopyOnWriteArrayList<>(photosToUpload);
            System.out.println("Фото успешно загружено! Path: " + photo);
            copyPhotosToUpload.removeIf(ph -> ph.equals(photo));
            photosToUpload = new CopyOnWriteArrayList<>(copyPhotosToUpload);
        });
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

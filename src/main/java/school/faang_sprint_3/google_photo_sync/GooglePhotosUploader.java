package school.faang_sprint_3.google_photo_sync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosUploader {

    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new ThreadInterruptException("interrupted while waiting for lock");
                }
            }
            uploadPhotos();
        }
    }

    public void addNewPhoto(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Uploading to the server " + photo));
        photosToUpload.clear();
    }
}

package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        synchronized (lock) {
            try {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Start method are wait...");
                    lock.wait();
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uploadPhotos() {
        photosToUpload
                .forEach(photo -> System.out.println("File: " + photo + "uploaded into Google Photo"));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo " + photoPath + " are added");
            lock.notify();
        }
    }
}

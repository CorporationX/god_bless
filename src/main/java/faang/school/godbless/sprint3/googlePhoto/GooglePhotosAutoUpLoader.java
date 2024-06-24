package faang.school.godbless.sprint3.googlePhoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglePhotosAutoUpLoader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public GooglePhotosAutoUpLoader() {
        photosToUpload.addAll(Arrays.asList("photo1", "photo2"));
    }

    public void startAutoUpload() {
        try {
            System.out.println("startAutoUpload");
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("startAutoUpload sync. thread is gonna call lock wait");
                    lock.wait();
                }
            }

            System.out.println("startAutoUpload. thread is gonna call upload photo");
            System.out.println("startAutoUpload. photos: " + photosToUpload);

            uploadPhotos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("upload photos sync");
            photosToUpload.forEach(photo -> System.out.println("Photo for loading in google photo: " + photo));
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("on new photo added sync");
            System.out.println("on new photo added sync. photos before adding: " + photosToUpload);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

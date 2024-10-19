package school.faang.multithreading.googlePhotoSync;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new CopyOnWriteArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (photosToUpload.isEmpty()) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                System.out.println("Starting the photo upload");
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Uploading photo: " + photo);
                photosToUpload.remove(photo);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }

}

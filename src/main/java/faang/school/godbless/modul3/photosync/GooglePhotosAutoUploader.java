package faang.school.godbless.modul3.photosync;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
                System.out.println("Auto uploading done." + "\n");
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(
                photoPath -> System.out.println("Photo " + photoPath + " was uploaded by " + Thread.currentThread())
        );
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added new photo " + photoPath + " by " + Thread.currentThread());
            lock.notify();
        }
    }
}

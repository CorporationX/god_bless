package faang.school.godbless.sprint3.BJS2_24475;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private boolean isAutoUploading = false;

    public void startAutoUpload() {
        synchronized (lock) {
            isAutoUploading = true;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Waiting for photos");
                        lock.wait();
                    }
                    if (isAutoUploading) {
                        uploadPhotos();
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) throws InterruptedException {
        synchronized (lock) {
            System.out.printf("Adding photo %s to queue%n", photoPath);
            Thread.sleep(1000);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Uploading photos...");
            photosToUpload.clear();
            System.out.println("Photos uploaded");
        }
    }
}

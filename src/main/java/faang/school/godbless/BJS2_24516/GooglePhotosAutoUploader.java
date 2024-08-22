package faang.school.godbless.BJS2_24516;

import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object LOCK = new Object();
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() {
        synchronized (LOCK) {
            while (true) {
                try {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Photos is empty");
                        LOCK.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            LOCK.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (LOCK) {
            while (!photosToUpload.isEmpty()) {
                String photo = photosToUpload.remove(0);
                System.out.println("Uploading " + photo);
            }
        }
    }
}

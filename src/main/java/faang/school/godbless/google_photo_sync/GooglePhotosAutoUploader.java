package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        System.out.println("New photos are uploading to server");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Photo " + photoPath + " added");
            photosToUpload.notify();
        }
    }
}

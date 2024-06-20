package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    photosToUpload.wait();
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Photos successfully uploaded to server");
        photosToUpload.clear();
    }
}

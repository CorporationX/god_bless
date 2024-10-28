package school.faang.bjs2_37440;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        if (photosToUpload.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        uploadPhotos();

    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notify();
    }

    private void uploadPhotos() {
        photosToUpload.forEach(s -> System.out.println("uploaded a photo with the path: " + s));
        photosToUpload.clear();
    }
}

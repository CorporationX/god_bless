package school.faang.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        while (true) {
            while (photosToUpload.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            uploadPhotos();
        }
    }

    public synchronized void uploadPhotos() {
        for (String path : photosToUpload) {
            System.out.println("Uploading photo: " + path);
        }
        photosToUpload.clear();
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notifyAll();
    }
}


package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                try {
                    while (photosToUpload.isEmpty()) {
                        photosToUpload.wait();
                    }
                    uploadPhoto();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private void uploadPhoto() {
        if (!photosToUpload.isEmpty()) {
            String photo = photosToUpload.remove(0);
            System.out.println("Uploading photo: " + photo);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }
}

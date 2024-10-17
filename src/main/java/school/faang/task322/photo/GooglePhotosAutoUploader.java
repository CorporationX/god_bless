package school.faang.task322.photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e.getMessage());
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notifyAll();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Фото " + photo + " Было загружено");
        }
        photosToUpload.clear();
    }
}

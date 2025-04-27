package school.faang.bjs2_73863;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    System.out.println("Время ожидания истекло");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (photosToUpload) {
            System.out.printf("Uploading photos, %s", photosToUpload);
            photosToUpload.clear();
        }
    }
}

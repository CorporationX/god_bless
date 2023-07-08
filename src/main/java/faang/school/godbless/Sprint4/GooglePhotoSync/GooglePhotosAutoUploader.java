package faang.school.godbless.Sprint4.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photoPath);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded (String photoPath){
        synchronized (lock) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }
}

package school.faang.sprint3.task48998google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    List<String> photosToUpload = new ArrayList<>();
    final int timeOut = 1000;

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            while (photosToUpload.isEmpty()) {
                photosToUpload.wait(timeOut);
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
        System.out.println("Загрузка фотографий на сервер...");
        photosToUpload.clear();
    }


}

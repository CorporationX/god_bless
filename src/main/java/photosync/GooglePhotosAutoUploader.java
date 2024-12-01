package photosync;

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
                    throw new IllegalArgumentException("Что-то произошло при вызове метода wait().");
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
            for (var photo : photosToUpload) {
                System.out.println("Загружаем фотографию " + photo);
            }
            photosToUpload.clear();
        }
    }
}

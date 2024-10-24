package googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Ждем загрузки фото");
                photosToUpload.wait();
            }
            uploadPhoto();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("В список добавлено фото");
            photosToUpload.notify();
        }
    }

    public void uploadPhoto() {
        System.out.println("Фотографии загружены");
        photosToUpload.clear();
    }

}

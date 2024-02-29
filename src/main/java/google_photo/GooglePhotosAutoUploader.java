package google_photo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(GooglePhoto googlePhoto) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos(googlePhoto);
            }
        }
    }

    public void onNewPhotoAdded(String url) {
        synchronized (lock) {
            photosToUpload.add(url);
            System.out.println(url + " загружено на сервер");
            lock.notify();
        }
    }

    public void uploadPhotos(GooglePhoto googlePhoto) {
        googlePhoto.getMyPhoto().add(photosToUpload.get(0));
        System.out.println(photosToUpload.get(0) + " добавлено в коллекцию");
        photosToUpload.remove(0);
    }
}

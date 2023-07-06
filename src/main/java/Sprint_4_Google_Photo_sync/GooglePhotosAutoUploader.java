package Sprint_4_Google_Photo_sync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    List<String> photosToUpload = new ArrayList();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos(photosToUpload);
                }
            }
        }
    }

    public void uploadPhotos(List<String> photosToUpload) {
        synchronized (lock) {
            //фор ич для каждой фоточки
            System.out.println("Загрузил фотки: " + photosToUpload.toString());
            photosToUpload.removeAll(photosToUpload);
        }
    }
    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавил фотку: " + photoPath);
            lock.notify();
        }
    }

    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread firstThread = new Thread(new GooglePhotosAutoUploader(googlePhoto));
        Thread secondThread = new Thread(new GooglePhotosAutoUploader(googlePhoto));
    }
}

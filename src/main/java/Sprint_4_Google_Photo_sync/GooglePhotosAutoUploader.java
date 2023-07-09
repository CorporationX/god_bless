package Sprint_4_Google_Photo_sync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    List<String> photosToUpload = new ArrayList();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(Thread.currentThread().getName() + " Добавил фотку: " + photoPath);
            lock.notifyAll();
        }
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " ээ я здесь");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos(photosToUpload);
                    System.out.println(Thread.currentThread().getName() + " я молодец, я загрузил фотки: " + photosToUpload.toString());
                }
            }
        }
    }

    public void uploadPhotos(List<String> photosToUpload) {
        synchronized (lock) {
            //for each можно для каждой фоточки
            System.out.println(Thread.currentThread().getName() + " Загрузил фотки: " + photosToUpload.toString());
            photosToUpload.removeAll(photosToUpload);
            System.out.println(Thread.currentThread().getName() + " Ниче нет: " + photosToUpload.toString());
        }
    }

    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread zeroThread = new Thread(() -> googlePhoto.onNewPhotoAdded("kotEk.jpg"));
        Thread firstThread = new Thread(() -> googlePhoto.onNewPhotoAdded("kotИk.jpg"));
        Thread secondThread = new Thread(() -> googlePhoto.onNewPhotoAdded("kotЁk.jpg"));
        Thread thirdThread = new Thread(() -> googlePhoto.startAutoUpload());
        Thread forthThread = new Thread(() -> googlePhoto.startAutoUpload());

        zeroThread.start();
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        forthThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}

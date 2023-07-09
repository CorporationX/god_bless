package Sprint_4_Task4;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();


    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " Ждет фото");
                    lock.wait();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(Thread.currentThread().getName() + " Добавили фото " + photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println(Thread.currentThread().getName() + " Загружаем фото " + photo);
            }
            photosToUpload.clear();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread t1 = new Thread(() -> {
            uploader.onNewPhotoAdded("1.jpg");
            uploader.onNewPhotoAdded("2.jpg");
            uploader.onNewPhotoAdded("3.jpg");
        });
        Thread t2 = new Thread(uploader::startAutoUpload);

        t1.start();
        t2.start();

        Thread.sleep(2000);

        System.exit(0);
    }
}

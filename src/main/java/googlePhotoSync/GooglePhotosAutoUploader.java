package googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private boolean startAutoUploadCalled = false;

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                if (!startAutoUploadCalled) {
                    System.out.println("Ожидание новых фотографий...");
                    startAutoUploadCalled = true;
                }
                lock.wait();
            }
            startAutoUploadCalled = false;
        }
    }

    public void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Загружаем фото...");
            Thread.sleep(3000);

            for (String photoPath : photosToUpload) {
                System.out.println("Загружена фотография: " + photoPath);
            }

            photosToUpload.clear();
            System.out.println("Фото загружены. Список для загрузки очищен.");
            lock.notifyAll();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader photoUploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(() -> {
            try {
                while (true) {
                    photoUploader.startAutoUpload();
                    photoUploader.uploadPhotos();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread viewerThread = new Thread(() -> {
            try {
                while (true) {
                    photoUploader.startAutoUpload();
                    System.out.println("Просмотр новых фотографий...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploaderThread.start();
        viewerThread.start();

         Thread.sleep(1000);

        photoUploader.onNewPhotoAdded("Путь_к_фото_1.jpg");
        photoUploader.onNewPhotoAdded("Путь_к_фото_2.jpg");

        Thread.sleep(5000);
        photoUploader.onNewPhotoAdded("Путь_к_фото_3.jpg");
    }
}




package faang.school.godbless.javasynchronized.task2;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<GooglePhoto> photosToUpload = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        String path = "https://media.istockphoto.com/id/1361394182/ru/%D1%84%D0%BE%D1%82%D0%BE/%D0%B7%D0%B0" +
                "%D0%B1%D0%B0%D0%B2%D0%BD%D1%8B%D0%B9-%D0%B1%D1%80%D0%B8%D1%82%D0%B0%D0%BD%D1%81%D0%BA%D0%B8%D0%B9-%D0" +
                "%BA%D0%BE%D1%80%D0%BE%D1%82%D0%BA%D0%BE%D1%88%D0%B5%D1%80%D1%81%D1%82%D0%BD%D1%8B%D0%B9-%D0%BF%D0%BE%" +
                "D1%80%D1%82%D1%80%D0%B5%D1%82-%D0%BA%D0%BE%D1%88%D0%BA%D0%B8-%D0%B2%D1%8B%D0%B3%D0%BB%D1%8F%D0%B4%D1%8" +
                "F%D1%89%D0%B8%D0%B9-%D1%88%D0%BE%D0%BA%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%8B%D0%BC-%D0%B8%D0" +
                "%BB%D0%B8-%D1%83%D0%B4%D0%B8%D0%B2%D0%BB%D0%B5%D0%BD%D0%BD%D1%8B%D0%BC.jpg?s=612x612&w=0&k=20&c=yEEyxv" +
                "dyb-jUxnHmr8nXSf9qQPS0WfkhBITLVIaj7OY=";
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            try {
                autoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                System.out.println("Завершение потока");
            }
        });

        Thread addedThread = new Thread(() -> autoUploader.onNewPhotoAdded(path));

        uploadThread.start();
        addedThread.start();

        Thread.sleep(1000L);
        uploadThread.interrupt();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Ожидаем фотографии");
                    lock.wait();
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        System.out.println("Загружаем фотографию на сервер " + photosToUpload.get(0).getPath());
        synchronized (lock) {
            photosToUpload.remove(0);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        System.out.println("Появилась новая фотография " + photoPath);
        synchronized (lock) {
            photosToUpload.add(new GooglePhoto(photoPath));
            lock.notify();
        }
    }
}

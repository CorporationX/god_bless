package faang.school.godbless.google_photo_sync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final Object lock2 = new Object();

    private final List<String> photosToUpload = new ArrayList<>();
    private final List<String> uploadedPhotos = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        String photo1 = "Photo1";
        String photo2 = "Photo2";
        String photo3 = "Photo3";
        String photo4 = "Photo4";
        String photo5 = "Photo5";
        String photo6 = "Photo6";
        String photo7 = "Photo7";

        Thread threadViewer = new Thread(googlePhotosAutoUploader::viewUploadPhotos);
        Thread threadUpload = new Thread(googlePhotosAutoUploader::startAutoUpload);

        threadViewer.start();
        threadUpload.start();

        Thread.sleep(3000);

        googlePhotosAutoUploader.onNewPhotoAdded(List.of(photo1, photo2, photo3));

        Thread.sleep(3000);

        googlePhotosAutoUploader.onNewPhotoAdded(List.of(photo4));

        Thread.sleep(3000);

        googlePhotosAutoUploader.onNewPhotoAdded(List.of(photo5, photo6));

        Thread.sleep(3000);

        googlePhotosAutoUploader.onNewPhotoAdded(List.of(photo7));
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Появились новые фото для загрузки: " + photosToUpload);

                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock2) {
            uploadedPhotos.addAll(photosToUpload);

            System.out.println("Все новые фото выгружены на сервер");

            photosToUpload.clear();

            lock2.notify();
        }
    }

    public void onNewPhotoAdded(List<String> photo) {
        synchronized (lock) {
            photosToUpload.addAll(photo);

            lock.notify();
        }
    }

    public void viewUploadPhotos() {
        while (true) {
            synchronized (lock2) {
                if (uploadedPhotos.isEmpty()) {
                    System.out.println("Список фото пуст");
                    System.out.println("-----------------------------------");
                } else {
                    System.out.println("Список фото на сервере: " + uploadedPhotos);
                    System.out.println("-----------------------------------");
                }
                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

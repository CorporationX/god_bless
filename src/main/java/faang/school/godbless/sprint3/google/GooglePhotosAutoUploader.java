package faang.school.godbless.sprint3.google;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
                System.out.println("Все фото загружены");
            }
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Фото %s загружено%n", photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }



    public static void main(String[] args) {
        List<String> photosToUpload = new ArrayList<>(List.of("Photo 1"));
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(new Object(), photosToUpload);
        List<String> photoPaths = new ArrayList<>(List.of("Photo 2", "Photo 3", "Photo 4", "Photo 5", "Photo 6",
                "Photo 7", "Photo 8", "Photo 9", "Photo 10", "Photo 11", "Photo 11", "Photo 12", "Photo 13", "Photo 14")) {
        };

        Thread autoUploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhotosToUploadListThread = new Thread(() -> photoPaths.forEach(googlePhotosAutoUploader::onNewPhotoAdded));
        autoUploadThread.start();
        addPhotosToUploadListThread.start();

        try {
            addPhotosToUploadListThread.join();
            autoUploadThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

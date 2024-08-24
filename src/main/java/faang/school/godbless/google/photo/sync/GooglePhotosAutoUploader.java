package faang.school.godbless.google.photo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread watchThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("photo1.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("photo2.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("photo3.jpg");
        });

        uploadThread.start();
        watchThread.start();
    }

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException exception) {
                        log.error("Interrupted exception was occurred while auto uploading photos", exception);
                        Thread.currentThread().interrupt();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        try {
            System.out.println("Photos uploading...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Photos uploading...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Photos have just uploaded...");
            photosToUpload.clear();
        } catch (InterruptedException exception) {
            log.error("Interrupted exception was occurred while uploading photos", exception);
            Thread.currentThread().interrupt();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            try {
                System.out.printf("Adding photo %s\n", photoPath);
                TimeUnit.SECONDS.sleep(2);
                photosToUpload.add(photoPath);
                photosToUpload.notify();
            } catch (InterruptedException exception) {
                log.error("Interrupted exception was occurred while adding photo to disk", exception);
                Thread.currentThread().interrupt();
            }
        }
    }
}

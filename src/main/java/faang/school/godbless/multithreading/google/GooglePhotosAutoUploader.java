package faang.school.godbless.multithreading.google;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@AllArgsConstructor
public class GooglePhotosAutoUploader {

    private final Queue<Photo> photosToUpload = new LinkedList<>();

    public void onNewPhotoAdded(Photo photo) {
        synchronized (photosToUpload) {
            while (photosToUpload.size() >= 3) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            photosToUpload.add(photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Adding " + photo.name());
            photosToUpload.notifyAll();
        }
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("No photos to upload. Waiting...");
                        photosToUpload.wait(4000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                uploadPhotos();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                photosToUpload.notifyAll();
            }
        }
    }

    private void uploadPhotos() {
        var photo = photosToUpload.poll();
        if (photo != null) {
            System.out.printf("%s is uploaded.\n", photo.name());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

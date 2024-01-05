package faang.school.godbless.alexbulgakoff.multithreading.synchronization.googlephoto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;
    private List<String> photoFromView;



    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
        photoFromView = new ArrayList<>();
    }

    public void startAutoUpload() {
        while(true) {
            if (!photosToUpload.isEmpty()) {
                synchronized (lock) {
                    uploadPhotos();
                    lock.notify();
                }
            }
            System.out.println("Waiting...");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Uploading photos...");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        photoFromView.addAll(photosToUpload);
        photosToUpload.clear();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cleaning uploading photo from the list...");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
        }
    }

    public void viewPhoto() {
        photoFromView.forEach(System.out::println);
    }
}

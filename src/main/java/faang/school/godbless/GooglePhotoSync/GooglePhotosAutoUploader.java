package faang.school.godbless.GooglePhotoSync;

import java.util.ArrayDeque;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final Queue<String> photosToUpload = new ArrayDeque<>() {};

    public void startUpAutoUpload() {
        synchronized(lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Upload " + photosToUpload.poll());
        startUpAutoUpload();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload.add(photoPath);
            System.out.println("New photo on the computer: " + photoPath);
            lock.notify();
        }
    }
}
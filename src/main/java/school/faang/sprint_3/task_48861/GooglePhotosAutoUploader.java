package school.faang.sprint_3.task_48861;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {
    private static final int WAIT_TIME = 5000;

    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        synchronized (lock) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (photosToUpload.isEmpty()) {
                        lock.wait(WAIT_TIME);
                    } else {
                        uploadPhotos();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Auto upload interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            Iterator<String> photosIterator = photosToUpload.iterator();
            while (photosIterator.hasNext()) {
                System.out.println(photosIterator.next() + " uploaded to Google Photos");
                photosIterator.remove();
            }
        }
    }
}

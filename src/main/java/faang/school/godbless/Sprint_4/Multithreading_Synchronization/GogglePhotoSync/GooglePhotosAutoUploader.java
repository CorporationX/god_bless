package faang.school.godbless.Sprint_4.Multithreading_Synchronization.GogglePhotoSync;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Lock lock = new ReentrantLock();
    private List<String> photosToUpload;

    public void startAutoUpload() {
        synchronized (lock) {
            if(photosToUpload.isEmpty()) {
                try {
                    System.out.println("waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Wait Error");
                }
            }

            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> System.out.printf("Photo - %s was uploaded to the Google Photos\n", photo));
            photosToUpload = new ArrayList<>();
        }
        startAutoUpload();
    }

}

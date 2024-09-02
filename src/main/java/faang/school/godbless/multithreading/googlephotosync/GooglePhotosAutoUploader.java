package faang.school.godbless.multithreading.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock){
            try {
                while (true){
                    if (photosToUpload.isEmpty()) {
                        System.out.println("> no photos, waiting");

                        lock.wait();
                    }
                    System.out.println("> thread is running");

                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.printf("> auto loader got an error: %s%n", e.getMessage());
            }
        }
    }

    public void uploadPhotos(){
        synchronized (lock){
            System.out.println("> loading to google cloud");

            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock){
            System.out.printf("> adding %s to list%n", photoPath);

            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

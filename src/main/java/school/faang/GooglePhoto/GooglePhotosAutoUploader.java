package school.faang.GooglePhoto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(){
        while (true){
            synchronized (lock){
                while(photosToUpload.isEmpty()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            while (!photosToUpload.isEmpty()) {
                String photoPath = photosToUpload.remove(photosToUpload.size() - 1);
                System.out.println("Uploading photo: " + photoPath);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println("Uploaded photo: " + photoPath);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock){
            photosToUpload.add(photoPath);
            System.out.println("Added photo: " + photoPath);
            lock.notify();
        }
    }

}

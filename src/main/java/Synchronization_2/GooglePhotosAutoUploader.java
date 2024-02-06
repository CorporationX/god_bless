package Synchronization_2;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private List<String> photoToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photoToUpload) {
            while (true) {
                if (photoToUpload.isEmpty()) {
                    try {
                        photoToUpload.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error synchronization");
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        System.out.println(photoToUpload.get(0) + " load to server.");
        photoToUpload.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photoToUpload) {
            photoToUpload.add(photoPath);
            photoToUpload.notify();
        }
    }

}

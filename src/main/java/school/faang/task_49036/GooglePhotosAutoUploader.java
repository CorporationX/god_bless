package school.faang.task_49036;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<String>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
                System.out.println("Waiting for photos to upload...");
            }
            uploadPhoto(photosToUpload);
        }
    }

    public void onNewPhoto(String photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
            System.out.println("New photo: " + photo);
            lock.notify();
        }
    }


    private void uploadPhoto(List<String> photos) {

        for (String photo : photos) {
            System.out.println("Uploading photo: " + photo);
        }
        photosToUpload.clear();
    }

}
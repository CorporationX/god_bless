package faang.school.godbless.BJS2_26018;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true){
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added new photo: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        System.out.println("Upload photos on Google photos");
        Thread.sleep(2000);
        photosToUpload.clear();
    }
}

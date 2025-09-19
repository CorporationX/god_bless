package school.faang.bjs2_90402;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private Lock lock = new ReentrantLock();
    private List<String> photosToUpload = new ArrayList<>();

    public void startToUpload() {
        synchronized (lock) {
            while (true) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("No photo to upload");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath.isEmpty()) {
            System.out.println("Photo cannot be empty");
            return;
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added: " + photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        List<String> photosToProcess = new ArrayList<>(photosToUpload);

        for (String photo : photosToProcess) {
            System.out.println("Upload photo:" + photo);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            photosToUpload.clear();
            System.out.println("Photo upload:" + photo);
        }
    }
}

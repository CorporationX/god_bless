package school.faang.bjs249118;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is working on uploading photos");
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            uploadPhotos();
            System.out.println(Thread.currentThread().getName() + " has finished");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is working on adding new photos");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println(Thread.currentThread().getName() + " has finished");
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String removed = photosToUpload.remove(photosToUpload.size() - 1);
            System.out.printf("%s uploading %s to the server%n", Thread.currentThread().getName(), removed);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        System.out.printf("%s finished uploading all photos%n", Thread.currentThread().getName());
    }

}

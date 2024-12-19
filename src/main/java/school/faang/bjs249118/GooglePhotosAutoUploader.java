package school.faang.bjs249118;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is working on uploading photos");
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                uploadPhotos();
            }
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
        String remove = photosToUpload.remove(photosToUpload.size() - 1);
        System.out.printf("%s uploading %s to the server%n", Thread.currentThread().getName(), remove);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

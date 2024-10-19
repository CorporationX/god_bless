package school.faang;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();

    private Object lock2 = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"come in");
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"...");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println(Thread.currentThread().getName()+"job");
        photosToUpload.forEach(System.out::println);
        if (photosToUpload.isEmpty()){
            System.out.println("no photos");
        }
        photosToUpload.clear();
    }
}

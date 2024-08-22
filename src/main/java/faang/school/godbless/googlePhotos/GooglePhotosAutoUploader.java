package faang.school.godbless.googlePhotos;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("start auto upload. wait");
                        lock.wait();
                    }
                    System.out.println("start auto upload");
                    uploadPhotos();
                }
            } catch (InterruptedException ie) {
                System.out.println("InterruptedException in startAutoUpload");
            }
        }
    }


    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Upload photo method started. List of photos " + photosToUpload);
            for (String photo : photosToUpload) {
                System.out.println(photo);
            }
            photosToUpload.clear();
            System.out.println("Upload photo method finished. List of photos " + photosToUpload);
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (lock) {
            System.out.println("On new photo added method started. List of photos " + photosToUpload);
            photosToUpload.add(photo);
            System.out.println("On new photo added method finished. List of photos " + photosToUpload);
            lock.notify();
        }
    }
}

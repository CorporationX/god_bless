package school.faang.task_48869;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Start uploading photos...");

        for (String photo : photosToUpload) {
            System.out.println("Loading: " + photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        photosToUpload.clear();
        System.out.println("All photos have been uploaded!");
    }
}
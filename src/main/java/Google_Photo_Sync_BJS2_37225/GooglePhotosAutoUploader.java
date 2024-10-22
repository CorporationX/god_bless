package Google_Photo_Sync_BJS2_37225;

import java.util.List;
import java.util.ArrayList;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("There isn't new photos. Waiting");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added" + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Uploading photo" + photo);
        }
        photosToUpload.clear();
    }
}
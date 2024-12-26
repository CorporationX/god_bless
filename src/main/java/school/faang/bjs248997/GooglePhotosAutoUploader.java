package school.faang.bjs248997;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private final int maxPhotosToUpload = 10;
    private int countUploadPhoto = 0;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        while (maxPhotosToUpload > countUploadPhoto) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("There are no photo to upload. Wait new photo.");
                    lock.wait();
                }
                uploadPhoto();
                countUploadPhoto++;
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("User added new " + photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhoto() {
        System.out.println("Photos have been successfully added to the Google Photo server");
        photosToUpload.clear();
    }
}

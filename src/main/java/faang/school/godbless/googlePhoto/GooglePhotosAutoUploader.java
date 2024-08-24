package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhoto(photosToUpload.get(new Random().nextInt(photosToUpload.size())));
        }
    }

    private void uploadPhoto(String photoPath) {
        System.out.println(photoPath + " has been uploaded");
        photosToUpload.remove(photoPath);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
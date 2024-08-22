package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhoto(photosToUpload.get(new Random().nextInt(photosToUpload.size())));
        }
    }

    private void uploadPhoto(String photoPath) {
        System.out.println(photoPath + " has been uploaded");
        photosToUpload.remove(photoPath);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }
}
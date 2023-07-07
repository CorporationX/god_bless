package faang.school.godbless.task.googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<GooglePhoto> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            for (; ; ) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("No photos for upload, waiting..");
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos() {
        try {
            Thread.sleep(1000);
            System.out.println(photosToUpload.size() + " photos was uploaded");
            photosToUpload.clear();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void onNewPhotoAdded(GooglePhoto photo) {
        synchronized (photosToUpload) {
            photosToUpload.add(photo);
            photosToUpload.notifyAll();
        }
    }
}

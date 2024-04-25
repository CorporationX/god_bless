package faang.school.godbless.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            do {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                } else {
                    uploadPhotos();
                }
            } while (true);
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(path ->
        {
            int index = path.strip().lastIndexOf("\\");
            System.out.println("Upload photo " +
                    path.strip().substring(index, path.length()).toLowerCase() +
                    " on Google Photos");
        });
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

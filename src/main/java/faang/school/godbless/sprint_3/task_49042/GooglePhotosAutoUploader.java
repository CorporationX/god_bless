package faang.school.godbless.sprint_3.task_49042;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Photo \"" + photoPath + "\" has been uploaded to the server");
        }
        photosToUpload.clear();
    }
}

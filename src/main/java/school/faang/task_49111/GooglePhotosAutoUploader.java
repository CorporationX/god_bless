package school.faang.task_49111;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Lock lock = new Lock();
    private final List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.size() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("!!!Exception!!! " + e);
                }
            }
            uploadPhotos();
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public final void uploadPhotos() {
        photosToUpload.forEach(s -> System.out.println("Photos from " + s + " is upload"));
        photosToUpload.clear();
    }


}

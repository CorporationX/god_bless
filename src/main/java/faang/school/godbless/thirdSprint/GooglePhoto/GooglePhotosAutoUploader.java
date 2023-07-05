package faang.school.godbless.thirdSprint.GooglePhoto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while(true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            Iterator<String> iterator = photosToUpload.iterator();
            while (iterator.hasNext()) {
                String photo = iterator.next();
                System.out.println("The photo '" + photo + "' was successfully uploaded to the server");
                iterator.remove();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}

package school.faang.bjs2_82015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GooglePhotosAutoUpload {
    private final Object lock = new Object();
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() {
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

    public void uploadPhotos() {
        photosToUpload.forEach(photoPath -> System.out.printf("%s was upload%n", photoPath));
        photosToUpload.clear();

    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("%s was added%n", photoPath);
            lock.notify();
        }
    }
}
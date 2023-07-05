package faang.school.godbless.spring_4.google_photo_sync;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhotosAutoUpLoader {

    private final Object lock = new Object();

    private final Queue<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {

        while (photosToUpload.isEmpty()) {
        }

        synchronized (lock) {
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        System.out.println(photosToUpload.poll());
    }

    public void onNewPhotoAdded(String photoPath) {

        synchronized (lock) {
            photosToUpload.add(photoPath);
        }
    }
}

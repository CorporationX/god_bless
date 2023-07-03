package faang.school.godbless.spring_4.google_photo_sync;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhotosAutoUpLoader {

    private final Queue<String> photosToUpload = new LinkedList<>();

    public synchronized void startAutoUpload() {

        while (photosToUpload.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("tralala");
            }
        }

        uploadPhotos();
        notify();
    }

    private void uploadPhotos() {
        System.out.println(photosToUpload.poll());
    }

    public synchronized void onNewPhotoAdded(String photoPath) {

        while (!photosToUpload.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("tralala");
            }
        }

        photosToUpload.add(photoPath);
        notify();
    }
}

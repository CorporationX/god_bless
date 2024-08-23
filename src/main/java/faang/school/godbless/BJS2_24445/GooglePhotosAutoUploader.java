package faang.school.godbless.BJS2_24445;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photoPaths = new ArrayList<>();

    public void startAutoUpdate() {
        synchronized (lock) {
            while (photoPaths.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Wait error");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photoPaths.add(photoPath);
            System.out.println("Add photo");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        IntStream.range(0, photoPaths.size())
                .forEach(i -> {
                    String photoPath = photoPaths.remove(0);
                    System.out.println("Upload to server: " + photoPath);
                });
    }
}


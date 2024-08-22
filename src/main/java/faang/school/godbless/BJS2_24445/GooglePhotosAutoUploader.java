package faang.school.godbless.BJS2_24445;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private final List<String> photoPaths = new ArrayList<>();

    public void startAutoUpdate() {

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

    private static void sleepWithCatchException(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
    }
}


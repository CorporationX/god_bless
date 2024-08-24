package faang.school.godbless.BJS2_24570;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    final Object lock = new Object();
    @Setter
    boolean stopAutoUploadThread = false;
    @Setter
    boolean stopNewPhotoThread = false;
    private final List<String> photosToUpload = new ArrayList<>(
            List.of("C://1.png", "C://2.png", "C://3.png", "C://4.png", "C://5.png"));

    public void startAutoUpload() {
        do {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread is interrupted");
                    }
                }
                uploadPhotos();
            }
        } while (!stopAutoUploadThread);
    }

    public void onNewPhotoAdded(String photoPath) {
        while (!stopNewPhotoThread) {
            synchronized (lock) {
                photosToUpload.add(photoPath);
                System.out.println("New photo added: " + photoPath);
                lock.notify();
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload.forEach(System.out::println);
        photosToUpload.clear();
    }
}

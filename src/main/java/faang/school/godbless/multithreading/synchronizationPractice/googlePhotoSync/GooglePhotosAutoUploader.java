package faang.school.godbless.multithreading.synchronizationPractice.googlePhotoSync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("ListPhotos is empty, need wait. When photos will be added.");
                    lock.wait();
                }
                uploadPhotos();
            }

        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String str : getPhotosToUpload()) {
                System.out.println("Upload photo from - " + str);
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
            System.out.println("Added new photo to download - " + photoPath);
        }
    }
}

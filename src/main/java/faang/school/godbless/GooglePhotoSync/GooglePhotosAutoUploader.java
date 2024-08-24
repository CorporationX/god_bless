package faang.school.godbless.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final List<String> uploadedPhotos = new ArrayList<>();

    private final Object lock = new Object();

    private void addPhotoToUpload(String photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("фоточек нема");
                    try {
                        lock.wait();
                        System.out.println("ооо фоточки поступили");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhoto(photosToUpload.remove(0));
            }
        }
    }

    private void uploadPhoto(String photoToUpload) {
        synchronized (lock) {
            System.out.println("выложил крутямбовую фоточку: " + photoToUpload);
            uploadedPhotos.add(photoToUpload);
        }
    }

    public void onNewPhotoAdded(String photoToUpload) {
        synchronized (lock) {
            addPhotoToUpload(photoToUpload);
            lock.notify();
        }
    }
}

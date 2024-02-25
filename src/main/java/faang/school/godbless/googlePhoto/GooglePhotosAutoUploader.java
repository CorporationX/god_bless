package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = new ArrayList<>(photosToUpload);
    }

    public void startAutoUpload(){
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    uploadPhotos();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            for (int i = photosToUpload.size() - 1; i >= 0; i--) {
                String photo = photosToUpload.get(i);
                System.out.printf("Upload photo %s", photo);
                System.out.println();
                Thread.sleep(1000);
                photosToUpload.remove(i);
            }
            System.out.println("All photos uploaded");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();
        }
    }
}

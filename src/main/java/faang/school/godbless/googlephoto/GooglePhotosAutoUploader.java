package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private GooglePhoto googlePhoto;
    private List<String> photosToUpload = new ArrayList<>();
    private final Object LOCK = new Object();

    public GooglePhotosAutoUploader(GooglePhoto googlePhoto) {
        this.googlePhoto = googlePhoto;
    }

    public void startAutoUpload() {
            while (true) {
                synchronized (LOCK) {
                    if (photosToUpload.isEmpty()) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                uploadPhotos();
            }
    }

    public void onNewPhotoAdded(String photoPath) {
        while (true) {
            synchronized (LOCK) {
                photosToUpload.add(photoPath);
                LOCK.notify();
            }
            System.out.println("Photo added");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photo...");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Uploaded");
        photosToUpload.clear();
    }
}

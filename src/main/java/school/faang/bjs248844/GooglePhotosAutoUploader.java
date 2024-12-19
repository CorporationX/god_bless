package school.faang.bjs248844;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    public final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUploadToServer() {
        synchronized (photosToUpload) {
            while (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    System.out.println("The thread was interrupted" + e.getMessage());
                }
            }
            uploadPhotosToServer();
        }
    }

    public void addNewPhoto(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    public void uploadPhotosToServer() {
        for (String photoPath : photosToUpload) {
            System.out.println("The photo was uploaded to the server " + photoPath);
        }
        photosToUpload.clear();
    }
}
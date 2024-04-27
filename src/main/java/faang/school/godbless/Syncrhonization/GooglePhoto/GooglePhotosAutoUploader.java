package faang.school.godbless.Syncrhonization.GooglePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object LOCK = new Object();
    private static final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (LOCK) {
                if (PHOTOS_TO_UPLOAD.isEmpty()) {
                    try {
                        System.out.println("Waiting for photos");
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        synchronized (LOCK) {
            for (String photo : PHOTOS_TO_UPLOAD) {
                System.out.println("Uploading photo: " + photo);
                System.out.println("Photo uploaded successfully: " + photo);
            }
            PHOTOS_TO_UPLOAD.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            PHOTOS_TO_UPLOAD.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            LOCK.notify();
        }
    }
}
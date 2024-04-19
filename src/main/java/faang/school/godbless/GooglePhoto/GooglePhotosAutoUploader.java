package faang.school.godbless.GooglePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object LOCK = new Object();
    private static final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (LOCK){
            while(PHOTOS_TO_UPLOAD.isEmpty()){
                System.out.println("Waiting for photos");
                LOCK.wait();
            }
            for (String photo : PHOTOS_TO_UPLOAD) {
                System.out.println("Auto uploading: " + photo);
            }
            PHOTOS_TO_UPLOAD.clear();
        }
    }

    public void uploadPhotos(String photoPath) {
        synchronized (LOCK){
            PHOTOS_TO_UPLOAD.add(photoPath);
            LOCK.notify();
        }
    }

    public void onNewPhotoAdded(String photoPath) throws InterruptedException {
        synchronized (LOCK){
            uploadPhotos(photoPath);
        }
    }
}

package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object object = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotosAutoUploader gp = new GooglePhotosAutoUploader();

        List<String> somePhotos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            somePhotos.add("photo " + i);
        }

        Thread uploadThread = new Thread(gp::startAutoUpload);
        for (String photo : somePhotos) {
            Thread photothread = new Thread(() -> gp.onNewPhotoAdded(photo));
            photothread.start();
        }
        uploadThread.start();
    }

    public void startAutoUpload() {
        synchronized (object) {
            while (photosToUpload.isEmpty()) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (object) {
            photosToUpload.add(photoPath);
            uploadPhotos();
            object.notify();
        }
    }

    public void uploadPhotos() {
        for (int i = 0; i < photosToUpload.size(); i++) {
            System.out.println("Photo " + i + " was uploaded");
            photosToUpload.remove(i);
            System.out.println("Photo " + i + " was deleted");
        }
        System.out.println("All photos was added and delete ");
    }
}

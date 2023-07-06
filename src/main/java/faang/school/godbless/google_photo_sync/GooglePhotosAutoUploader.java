package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photoPath = List.of("path1", "path2", "path3");
        googlePhotosAutoUploader.startAutoUpload();
        for(String photo: photoPath){
            new Thread(()-> googlePhotosAutoUploader.onNewPhotoAdded(photo)).start();
        }
    }
    Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        lock.notifyAll();
    }

    public void uploadPhotos() {
        System.out.println("Фото загружено");
        photosToUpload.remove(0);

    }
}

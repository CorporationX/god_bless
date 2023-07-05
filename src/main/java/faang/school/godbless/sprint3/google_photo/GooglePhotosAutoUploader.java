package faang.school.godbless.sprint3.google_photo;

import lombok.Data;

import java.util.List;
@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = List.of();


    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if(photosToUpload.isEmpty()) {
                System.out.println("No photos to upload");
                photosToUpload.wait();
            }else uploadPhotos();
        }
    }
    public void uploadPhotos() {
        System.out.println("Uploaded photos");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added");
            photosToUpload.notify();
        }
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread thread = new Thread(() -> googlePhoto.onNewPhotoAdded ("photo.jpg"));
        Thread thread1 = new Thread(googlePhoto::getPhotosToUpload);
        thread.start();
        thread1.start();
    }

}

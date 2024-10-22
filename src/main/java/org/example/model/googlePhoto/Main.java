package org.example.model.googlePhoto;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread autoPhotoUpload = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        Thread addPhotoThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("pathToPhoto"));

        autoPhotoUpload.start();
        Thread.sleep(2000);
        addPhotoThread.start();
    }
}

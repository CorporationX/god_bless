package bjs290346;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadPhotosThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread addNewPhotosThread = new Thread(() -> uploader.onNewPhotoAdded("photoAddress"));

        uploadPhotosThread.start();
        addNewPhotosThread.start();

        uploadPhotosThread.join();
        addNewPhotosThread.join();
    }
}

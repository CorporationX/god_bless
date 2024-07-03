package faang.school.godbless.googlephoto;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread startPhotoThread = new Thread(uploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> uploader.onNewPhotoAdded("Photo.jpg"));
        Thread.sleep(1000);
        startPhotoThread.start();
        addPhotoThread.start();

        startPhotoThread.join();
        addPhotoThread.join();

        System.out.println("All threads are ended");

    }
}

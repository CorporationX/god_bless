package faang.school.godbless.bjs2_26009;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotos::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> googlePhotos.onNewPhotoAdded("photo1.jpg"));

        uploadThread.start();
        addPhotoThread.start();

        Thread.sleep(5000);

        Thread addPhotoThread2 = new Thread(() -> googlePhotos.onNewPhotoAdded("photo2.jpg"));
        addPhotoThread2.start();
    }
}

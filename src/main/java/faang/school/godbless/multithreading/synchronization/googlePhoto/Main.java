package faang.school.godbless.multithreading.synchronization.googlePhoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread loaderThread = new Thread(uploader::startAutoUpload);
        Thread adderThread = new Thread(() -> uploader.onNewPhotoAdded("photo 1"));

        loaderThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted main");
        }

        adderThread.start();
    }
}

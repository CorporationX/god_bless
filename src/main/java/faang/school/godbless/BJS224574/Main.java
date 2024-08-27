package faang.school.godbless.BJS224574;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhoto::startAutoUpload);
        uploadThread.start();

        Thread addedThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                googlePhoto.onNewPhotoAdded("photo #1.jpg");
                Thread.sleep(2000);
                googlePhoto.onNewPhotoAdded("photo #2.jpg");
                Thread.sleep(2000);
                googlePhoto.onNewPhotoAdded("photo #3.jpg");
                Thread.sleep(2000);
                googlePhoto.onNewPhotoAdded("photo #4.jpg");
                uploadThread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
        addedThread.start();
    }
}

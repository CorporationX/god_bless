package faang.school.godbless.BJS2_24578;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread startAutoUploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread onNewPhotoAddedThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                googlePhotosAutoUploader.onNewPhotoAdded("photo1.png");
                Thread.sleep(3000);
                googlePhotosAutoUploader.onNewPhotoAdded("photo2.png");
                Thread.sleep(1000);
                googlePhotosAutoUploader.onNewPhotoAdded("photo3.png");
                Thread.sleep(500);
                googlePhotosAutoUploader.onNewPhotoAdded("photo4.png");
                Thread.sleep(2000);
                googlePhotosAutoUploader.onNewPhotoAdded("photo5.png");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        startAutoUploadThread.start();
        onNewPhotoAddedThread.start();
    }
}

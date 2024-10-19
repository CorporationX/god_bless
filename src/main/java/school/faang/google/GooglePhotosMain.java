package school.faang.google;

public class GooglePhotosMain {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        uploader.startAutoUpload();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                uploader.onNewPhotoAdded("photo11.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}

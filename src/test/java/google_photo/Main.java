package google_photo;

public class Main {
    public static void main(String[] args) {
        GooglPhotosAutoUploader photosAutoUploader = new GooglPhotosAutoUploader();
        Thread threadAutoUploader = new Thread(() -> photosAutoUploader.startAutoUpload());
        Thread threadonNewPhotoAdded = new Thread(() -> {
            photosAutoUploader.onNewPhotoAdded("photo1.jpg");
            photosAutoUploader.onNewPhotoAdded("photo2.jpg");
            photosAutoUploader.onNewPhotoAdded("photo3.jpg");
        });
        threadAutoUploader.start();
        threadonNewPhotoAdded.start();
    }
}
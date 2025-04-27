package school.faang.googlephoto;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadPhotos = new Thread(photosAutoUploader::startAutoUpload);
        Thread addPhotos = new Thread(() -> {
            try {
                photosAutoUploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                photosAutoUploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1000);
                photosAutoUploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        uploadPhotos.start();
        addPhotos.start();
    }
}
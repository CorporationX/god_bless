package photo.sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread autoUploadPhotos = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread addNewPhotos = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("Photo 1");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo 2");
            googlePhotosAutoUploader.onNewPhotoAdded("Photo 3");
        });
        autoUploadPhotos.start();
        addNewPhotos.start();
    }
}

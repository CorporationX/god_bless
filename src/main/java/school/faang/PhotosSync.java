package school.faang;

public class PhotosSync {

    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread autoUploadThread = new Thread(() -> autoUploader.startAutoUpload());
        autoUploadThread.start();

        Thread uploadPhotosThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("Photo1");
            autoUploader.onNewPhotoAdded("Photo2");
            autoUploader.onNewPhotoAdded("Photo3");
        });

        uploadPhotosThread.start();
    }
}

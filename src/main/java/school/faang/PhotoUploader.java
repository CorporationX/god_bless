package school.faang;

public class PhotoUploader {
    private static final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    public static void main(String[] args) {
        Thread photoUploaderThread = new Thread(uploader::startAutoUpload);
        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("Downloads/cat.jpg");
            uploader.onNewPhotoAdded("Downloads/dog.jpg");
            uploader.onNewPhotoAdded("Downloads/photo.jpg");
        });

        photoUploaderThread.start();
        photoAdderThread.start();
    }
}

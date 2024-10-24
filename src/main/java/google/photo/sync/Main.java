package google.photo.sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
        });

        uploaderThread.start();
        addPhotosThread.start();
    }
}

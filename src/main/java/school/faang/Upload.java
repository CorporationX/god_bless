package school.faang;

public class Upload {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> uploader.startAutoUpload());

        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}


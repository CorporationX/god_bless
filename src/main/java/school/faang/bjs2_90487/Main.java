package school.faang.bjs2_90487;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}

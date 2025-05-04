package school.faang.BJS2_73782;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                uploader.onNewPhotoAdded("path/to/new_photo.jpg");
                uploader.onNewPhotoAdded("path/to/new_photo2.jpg");
                uploader.onNewPhotoAdded("path/to/new_photo3.jpg");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}

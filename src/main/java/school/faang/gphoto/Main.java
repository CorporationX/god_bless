package school.faang.gphoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotoAutoUploader googlePhotoAutoUploader = new GooglePhotoAutoUploader();

        Thread photoAutoUploaderThread = new Thread(() -> {
            try {
                googlePhotoAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread newPhotoUploadThread = new Thread(() -> {
            googlePhotoAutoUploader.onNewPhotoAdded("photo1path");
            googlePhotoAutoUploader.onNewPhotoAdded("photo2path");
            googlePhotoAutoUploader.onNewPhotoAdded("photo3path");
        });
        photoAutoUploaderThread.start();
        newPhotoUploadThread.start();
    }
}

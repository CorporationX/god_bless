package school.faang.bjs2_92402;

public class Main {
    public static void main(String[] args) {
        GooglePhotoAutoUploader googlePhotoAutoUploader = new GooglePhotoAutoUploader();
        Thread autoUploadThread = new Thread(() -> {
            try {
                googlePhotoAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread newPhotoaddedThread = new Thread(() -> googlePhotoAutoUploader.onNewPhotoAdded("Photo1"));
        autoUploadThread.start();
        newPhotoaddedThread.start();
    }
}

package school.faang.bjs2_90590;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread addPhotoThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("FirstPhoto");
            googlePhotosAutoUploader.onNewPhotoAdded("SecondPhoto");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            googlePhotosAutoUploader.onNewPhotoAdded("ThirdPhoto");
        });
        Thread uploadPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                googlePhotosAutoUploader.startAutoUpload();
                Thread.sleep(2000);
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        addPhotoThread.start();
        uploadPhotoThread.start();
    }
}

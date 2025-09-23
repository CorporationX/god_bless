package school.faang.bjs2_90590;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                googlePhotosAutoUploader.onNewPhotoAdded("FirstPhoto");
                Thread.sleep(2000);
                googlePhotosAutoUploader.onNewPhotoAdded("SecondPhoto");
                Thread.sleep(5000);
                googlePhotosAutoUploader.onNewPhotoAdded("ThirdPhoto");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        Thread uploadPhotoThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        addPhotoThread.start();
        uploadPhotoThread.start();
    }
}

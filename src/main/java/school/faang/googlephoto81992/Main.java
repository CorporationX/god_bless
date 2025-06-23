package school.faang.googlephoto81992;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploadTread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread addNewPhotosThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("rewerq");
            googlePhotosAutoUploader.onNewPhotoAdded("eqweqw");

        });

        autoUploadTread.start();
        addNewPhotosThread.start();

        autoUploadTread.join();
        addNewPhotosThread.join();

    }
}

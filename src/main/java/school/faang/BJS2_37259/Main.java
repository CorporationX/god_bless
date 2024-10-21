package school.faang.BJS2_37259;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUploader);

        Thread photoThread = new Thread(() -> {
            uploader.onNewPhoto("photo1.jpg");
            uploader.onNewPhoto("photo2.jpg");
            uploader.onNewPhoto("photo3.jpg");
            uploader.onNewPhoto("photo4.jpg");
            uploader.onNewPhoto("photo5.jpg");
        });

        uploadThread.start();
        photoThread.start();
    }
}

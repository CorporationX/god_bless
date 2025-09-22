package school.faang.multithreading.sinchronized.bjs2_90384;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> {
            uploader.onNewPhotoAdded("Path1*.jpg");
            uploader.onNewPhotoAdded("Path2*.jpg");
            uploader.onNewPhotoAdded("Path3*.jpg");
            uploader.onNewPhotoAdded("Path4*.jpg");
        });

        autoUploadThread.start();
        addPhotoThread.start();
    }
}

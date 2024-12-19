package school.faang.task_48882;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1500);
                uploader.onNewPhotoAdded("photo3.jpg");
                Thread.sleep(1000);
                uploader.stop();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "PhotoAdderThread");

        uploadThread.start();
        photoAdderThread.start();
    }
}


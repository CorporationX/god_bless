package school.faang.task_48869;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                uploader.onNewPhotoAdded("photo2.jpg");

                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo3.jpg");
                uploader.onNewPhotoAdded("photo4.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}
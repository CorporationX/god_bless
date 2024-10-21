package school.faang.googlephotosync;

public class PhotoUploaderApp {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo3.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo4.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Photo adding process interrupted.");
            }
        });

        uploadThread.start();
        photoAdderThread.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        uploadThread.interrupt();
        photoAdderThread.interrupt();
        System.out.println("Application terminated.");
    }
}





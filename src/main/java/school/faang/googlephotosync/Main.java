package school.faang.googlephotosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            uploader.startAutoUploader();
        });

        Thread addPhotosThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo1.jpg");

                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");

                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo3.jpg");

                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo4.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            uploadThread.join();
            addPhotosThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package faang.school.godbless.googlePhoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread viewerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        viewerThread.start();
    }

}

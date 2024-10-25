package school.faang.BJS2_37479;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread addPhotosThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded(" ......");

                Thread.sleep(3000);
                uploader.onNewPhotoAdded("........");

                Thread.sleep(2000);
                uploader.onNewPhotoAdded("........");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
        uploadThread.start();
        addPhotosThread.start();
    }
}

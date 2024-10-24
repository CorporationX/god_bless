package school.faang.BJS2_37296;

public class PhotoUploaderApp {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo3.jpg");
                uploader.stopAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток добавления фотографий был прерван.");
            }
        });

        uploadThread.start();
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
        }
    }
}

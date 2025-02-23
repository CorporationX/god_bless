package googlePhotos;


public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread thread1 = new Thread(() -> uploader.startAutoUpload());
        Thread thread2 = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        thread1.start();
        thread2.start();
    }
}

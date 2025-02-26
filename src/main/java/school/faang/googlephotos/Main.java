package school.faang.googlephotos;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread autoUploaderThread = new Thread(autoUploader::startAutoUpload);
        Thread photosAdderThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("photo1.jpeg");
            autoUploader.onNewPhotoAdded("photo2.jpeg");
        });

        autoUploaderThread.start();
        photosAdderThread.start();
    }
}

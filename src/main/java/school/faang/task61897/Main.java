package school.faang.task61897;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread autoUploader = new Thread(uploader::startAutoUpload);
        Thread photoUploader = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                uploader.onNewPhotoAdded("Photo.jpeg");
            }
        });

        autoUploader.start();
        photoUploader.start();
    }
}

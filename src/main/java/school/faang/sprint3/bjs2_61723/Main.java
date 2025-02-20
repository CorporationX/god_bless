package school.faang.sprint3.bjs2_61723;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread photoUploader = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread photoAdder = new Thread(() ->
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\...jpg"));

        photoUploader.start();
        photoAdder.start();
    }
}

package school.faang.googlephotosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();

        Thread photoAdderThread = new Thread(() -> photosUploader.onNewPhotoAdded("image1.jpg"));
        Thread uploaderThread = new Thread(() -> photosUploader.startAutoUpload());

        uploaderThread.start();
        photoAdderThread.start();
    }
}

package googlePhoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread first = new Thread(() -> googlePhoto.onNewPhotoAdded("example.jpg"));
        Thread second = new Thread(googlePhoto::uploadPhotos);

        first.start();
        second.start();


    }
}

package google.photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();

        for (int i = 0; i < 100; i++) {
            String photoNumber = String.valueOf(i + 1234);
            new Thread(() -> googlePhotos.onNewPhotoAdded(photoNumber)).start();
            new Thread(googlePhotos::startAutoUpload).start();
        }
    }
}

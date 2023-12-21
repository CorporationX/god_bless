package Google;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        PhotoAdder photoAdder = new PhotoAdder(googlePhotosAutoUploader);
        PhotoUploader photoUploader = new PhotoUploader(googlePhotosAutoUploader);

        Thread adderPhotos = new Thread(photoAdder);
        Thread uploaderPhotos = new Thread(photoUploader);

        adderPhotos.start();
        uploaderPhotos.start();
    }
}

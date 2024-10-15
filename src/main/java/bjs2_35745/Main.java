package bjs2_35745;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread threadUpload = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        String photoFileName = "somephoto.jpg";
        Thread threadAddPhoto = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(photoFileName));

        threadUpload.start();
        threadAddPhoto.start();
    }
}

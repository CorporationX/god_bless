package school.faang.bjs248997;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread serverGoogle = new Thread(new ServerGooglePhotos(googlePhotosAutoUploader));
        Thread user = new Thread(new User(googlePhotosAutoUploader));

        serverGoogle.start();
        user.start();
    }
}

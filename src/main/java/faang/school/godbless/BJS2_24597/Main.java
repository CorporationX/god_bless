package faang.school.godbless.BJS2_24597;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();

        Thread uploadPhotos = new Thread(googlePhotos::startAutoUpload);
        Thread checkUploaded = new Thread(() ->
                googlePhotos.onNewPhotoAdded(googlePhotos.getSaltString()));

        checkUploaded.start();
        uploadPhotos.start();
    }
}

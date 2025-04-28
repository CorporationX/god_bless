package school.faang.bjs273743;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadPhotosThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addNewPhotosThread = new Thread(() ->
                googlePhotosAutoUploader.onNewPhotoAdded("image1"));
        uploadPhotosThread.start();
        addNewPhotosThread.start();
    }
}
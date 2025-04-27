package school.faang.bjs2_73863;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        String path = "smth";
        Thread firstThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(path));
        Thread secondThread = new Thread(googlePhotosAutoUploader::startAutoUpload);

        secondThread.start();
        firstThread.start();
    }
}

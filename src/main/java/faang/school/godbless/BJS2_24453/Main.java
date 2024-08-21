package faang.school.godbless.BJS2_24453;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread addPhotosThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded());
        Thread uploadPhotosThread = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());

        uploadPhotosThread.start();
        Thread.sleep(5000);
        addPhotosThread.start();
        addPhotosThread.join();
        uploadPhotosThread.join();
    }
}

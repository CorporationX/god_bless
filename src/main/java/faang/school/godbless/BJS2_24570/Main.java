package faang.school.godbless.BJS2_24570;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("D://newPhoto1.jpg"));

        uploadThread.start();
        addThread.start();
        try {
            Thread.sleep(5000);
            uploadThread.interrupt();
            addThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Все потоки завершены!");
        }

    }
}
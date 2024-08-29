package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        AutoUploaderThread autoUploaderThread = new AutoUploaderThread(googlePhotosAutoUploader);
        Thread autoUploader = new Thread(autoUploaderThread);
        autoUploader.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread adderThread1 = new Thread(new PhotoAdderThread(googlePhotosAutoUploader, "photo1.jpg"));
        Thread adderThread2 = new Thread(new PhotoAdderThread(googlePhotosAutoUploader, "photo2.jpg"));

        adderThread1.start();
        adderThread2.start();
    }
}
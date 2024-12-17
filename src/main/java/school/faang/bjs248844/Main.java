package school.faang.bjs248844;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Runnable runnableAuto = new PhotoAutoUploader(uploader);
        Runnable runnableAdder = new PhotoAdder(uploader);

        Thread thread1 = new Thread(runnableAuto);
        Thread thread2 = new Thread(runnableAdder);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
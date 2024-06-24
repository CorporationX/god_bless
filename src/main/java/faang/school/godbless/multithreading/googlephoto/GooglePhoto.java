package faang.school.godbless.multithreading.googlephoto;

public class GooglePhoto {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader  googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread startPhotoThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Лето.jpg"));

        startPhotoThread.start();
        Thread.sleep(1000);
        addPhotoThread.start();

        addPhotoThread.join();
        startPhotoThread.join();

        System.out.println("Все потоки завершены");
    }
}

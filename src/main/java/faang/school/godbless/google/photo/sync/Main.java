package faang.school.godbless.google.photo.sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader photos = new GooglePhotosAutoUploader();
        photos.onNewPhotoAdded("photos1");
        photos.onNewPhotoAdded("photos2");
        photos.onNewPhotoAdded("photos3");

        photos.startAutoUpload();

        Runnable runnable1 = () -> photos.uploadPhotos();
        Runnable runnable2 = () -> photos.uploadPhotos();
        Runnable runnable3 = () -> photos.uploadPhotos();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

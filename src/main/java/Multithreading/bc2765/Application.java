package Multithreading.bc2765;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread threadToAdded = new Thread(() -> {
            googlePhoto.oneNewPhotoAdded("Some photo1");
            googlePhoto.oneNewPhotoAdded("Some photo2");
            googlePhoto.oneNewPhotoAdded("Some photo3");
            googlePhoto.oneNewPhotoAdded("Some photo4");
            googlePhoto.oneNewPhotoAdded("Some photo5");
            try {
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadStartToUpload = new Thread(() -> {
            try {
                Thread.sleep(1000);
                googlePhoto.oneNewPhotoAdded("Some photo6");
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadStartToUpload1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                googlePhoto.oneNewPhotoAdded("Some photo7");
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadToAdded.start();
        threadStartToUpload.start();
        threadStartToUpload1.start();
        Thread.sleep(5000);
        System.exit(0);
    }
}

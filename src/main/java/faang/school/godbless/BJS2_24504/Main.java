package faang.school.godbless.BJS2_24504;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread uploadPhotos = new Thread(() -> {
            try {
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread viewPhoto = new Thread(() -> {
            try {
                Thread.sleep(2000);
                googlePhoto.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                googlePhoto.onNewPhotoAdded("photo2.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        uploadPhotos.start();
        viewPhoto.start();

        try {
            viewPhoto.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        uploadPhotos.interrupt();

    }
}

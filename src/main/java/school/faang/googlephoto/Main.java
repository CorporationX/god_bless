package school.faang.googlephoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread thread = new Thread(() -> {
            try {
                googlePhoto.startToUpload();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Поток был прерван", e);
            }
        });

        Thread thread2 = new Thread(() -> {
            googlePhoto.onNewPhotoAdded("new photo2.jpg");
            googlePhoto.onNewPhotoAdded("new photo3.jpg");
        });

        thread2.start();
        thread.start();
    }
}

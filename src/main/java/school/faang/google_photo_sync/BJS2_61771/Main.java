package school.faang.google_photo_sync.BJS2_61771;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread photoUploader = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread photoAdditions = new Thread(() -> {
            uploader.onNewPhotoAdded(
                    "C:\\Users\\Anonymous\\Desktop\\Images\\1MVVN8GB8TZD9852V9BAM1EEE0.jpeg");
        });

        photoAdditions.start();
        photoUploader.start();
    }
}

package school.faang.bjs2_81955;

public class Main {
    private static GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

    public static void main(String[] args) {
        new Thread(() -> autoUploader.startAutoUpload()).start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                autoUploader.onNewPhotoAdded("path/to/new_photo.jpg");
            }
        }).start();
    }
}

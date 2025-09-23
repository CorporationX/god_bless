package school.faang.bjs2_92360;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread photoUploader = new Thread(autoUploader::startAutoUpload);
        Thread photoAdder = new Thread(() -> {
            autoUploader.onNewPhotoAdded("секретное фото новых сухариков");
            autoUploader.onNewPhotoAdded("не секретное фото старых кириешек");
        });

        photoUploader.start();
        photoAdder.start();
    }
}

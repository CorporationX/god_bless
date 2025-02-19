package school.faang.BJS2_63627;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoLoader = new GooglePhotosAutoUploader();

        Thread autoLoading = new Thread(() -> autoLoader.startAutoUpload());

        Thread photoAdder = new Thread(() -> {
            autoLoader.onNewPhotoAdded("Фотография 1 ");
            autoLoader.onNewPhotoAdded("Фотография 2 ");
        });

        autoLoading.start();
        photoAdder.start();
    }
}
package faang.school.godbless.module1.sprint3.task9;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String googlePhoto = "new path for Google Photo";
        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();
        Thread threadLoader = new Thread(() -> {
            try {
                loader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadLoader.start();
        Thread threadAddPhoto = new Thread(() -> loader.onNewPhotoAdded(googlePhoto));
        threadAddPhoto.start();
        threadAddPhoto.join();
        threadLoader.join();
    }
}

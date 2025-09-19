package school.faang.bjs2_90505;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread threadAdderNewPhotos = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                uploader.onNewPhotoAdded("Photo " + i);
            }
        });
        Thread threadUploader = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadAdderNewPhotos.start();
        threadUploader.start();
    }
}

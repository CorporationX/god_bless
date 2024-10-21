package school.faang.synchronization.google;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photoUploader = new GooglePhotosAutoUploader();
        String testData1 = "test photo path 1";
        String testData2 = "test photo path 2";
        Thread threadAutomaticUpload = new Thread(photoUploader::startAutoUpload);
        Thread threadAddNewPhotos = new Thread(() -> {
            photoUploader.onNewPhotoAdded(testData1);
            photoUploader.onNewPhotoAdded(testData2);
        });
        threadAutomaticUpload.start();
        threadAddNewPhotos.start();
    }
}

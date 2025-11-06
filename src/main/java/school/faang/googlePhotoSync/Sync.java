package school.faang.googlePhotoSync;

public class Sync {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        Thread downloader = new Thread(googlePhotos::startAutoUpload);
        Thread downloader2 = new Thread(googlePhotos::startAutoUpload);
        Thread downloader3 = new Thread(googlePhotos::startAutoUpload);
        Thread uploader = new Thread(() -> googlePhotos.onNewPhotoAdded("new path"));
        Thread uploader2 = new Thread(() -> googlePhotos.onNewPhotoAdded("new path"));
        downloader.start();
        downloader2.start();
        downloader3.start();
        uploader.start();
//        uploader2.start();


    }
}

package googlePhoto;

public class GooglePhotoService {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        GooglePhoto photo1 = new GooglePhoto("C://images//cat.jpeg");

        Thread threadAddPhoto = new Thread(() -> uploader.onNewPhotoAdded(photo1.getPath()));
        Thread threadUploadPhoto = new Thread(uploader::startAutoUpload);

        threadUploadPhoto.start();
        threadAddPhoto.start();
    }
}

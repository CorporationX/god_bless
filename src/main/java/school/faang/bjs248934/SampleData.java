package school.faang.bjs248934;

public class SampleData {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread thr1 = new Thread(uploader::startAutoUpload);
        Thread thr2 = new Thread(uploader::addNewPhotos);

    }
}

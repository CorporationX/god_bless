package school.faang.bjs249118;

public class Main {

    public static void main(String[] args) throws Exception {
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();
        Thread one = new Thread(() -> photosUploader.startAutoUpload());
        Thread two = new Thread(() -> photosUploader.onNewPhotoAdded("test photo"));
        one.start();
        Thread.sleep(10000);
        two.start();
    }

}

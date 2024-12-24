package school.faang.spring3.task_48983;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread upload = new Thread(uploader::startAutoUpload);
        Thread addNewFile = new Thread(() -> uploader.onNewPhotoAdded("somepath"));
        upload.start();
        addNewFile.start();
    }
}

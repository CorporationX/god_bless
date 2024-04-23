package BJS2_5962;

public class Main {
    public static void main(String[] args) {
        GooglePhoto photo = new GooglePhoto("С:\\file\\vzlom\\1488.java");
        GooglePhotosAutoUploader googleProcessor = new GooglePhotosAutoUploader();

        Thread addNewPhoto = new Thread(() -> googleProcessor.onNewPhotoAdded(photo.getPath()));
        Thread uploadPhoto = new Thread(googleProcessor::startAutoUpload);


        uploadPhoto.start();
        addNewPhoto.start();
    }
}

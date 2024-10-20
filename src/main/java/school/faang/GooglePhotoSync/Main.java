package school.faang.GooglePhotoSync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        String newPhoto = "C:\\Users\\bogda\\Desktop";

        Thread autoUpload = new Thread(uploader::uploadPhotos);
        Thread newPhotoAdding = new Thread(() -> uploader.onNewPhotoAdded(newPhoto));
        autoUpload.start();
        newPhotoAdding.start();
    }
}

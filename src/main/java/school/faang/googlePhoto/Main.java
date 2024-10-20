package school.faang.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> pathsToPhoto = new ArrayList<>();
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        googlePhoto.setPhotosToUpload(pathsToPhoto);
        Thread firstThread = new Thread(googlePhoto::startAutoUpload);
        Thread secondThread = new Thread(() -> googlePhoto.onNewPhotoAdded("/path/to/photo.jpg"));
        firstThread.start();
        secondThread.start();
    }
}

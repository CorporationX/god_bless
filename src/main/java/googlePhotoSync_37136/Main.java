package googlePhotoSync_37136;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>(List.of("photo1.jpg", "photo2.jpg", "photo3.jpg", "photo4.jpg"));

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread autoUploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> photos.forEach(uploader::onNewPhotoAdded));

        autoUploadThread.start();
        addPhotosThread.start();
    }
}

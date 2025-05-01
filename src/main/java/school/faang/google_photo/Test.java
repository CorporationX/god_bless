package school.faang.google_photo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> paths = new ArrayList<>(List.of("path1", "path2", "path3", "path4", "path5"));

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread thread1 = new Thread(() -> paths.forEach(uploader::onNewPhotoAdded));
        Thread thread2 = new Thread(uploader::startAutoUpload);

        thread1.start();
        thread2.start();

    }
}

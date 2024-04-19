package GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> newPhotos = addPhotoPath();

        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread searchPhoto = new Thread(() -> {
            newPhotos.forEach(newPhoto -> autoUploader.onNewPhotoAdded(newPhoto));
        });
        Thread uploadThread = new Thread(() -> autoUploader.startAutoUpload());

        searchPhoto.start();
        uploadThread.start();

        searchPhoto.join();
        uploadThread.join();
    }

    private static List<String> addPhotoPath() {
        List<String> photos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            photos.add("new_photo_133" + (i * 10));
        }
        return photos;
    }
}

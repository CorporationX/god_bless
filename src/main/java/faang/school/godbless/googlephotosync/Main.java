package faang.school.godbless.googlephotosync;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(photosUploader::startAutoUpload);
        Thread photoAdder = new Thread(() -> {
            String photoPath = String.format("/users/username/documents/%d.png", new Random().nextInt(10));
            photosUploader.onNewPhotoAdded(photoPath);
        });

        uploader.start();
        photoAdder.start();
    }
}

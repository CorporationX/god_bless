package school.faang;

import school.faang.BJS2_37235.GooglePhotosAutoUpload;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUpload uploader = new GooglePhotosAutoUpload();
        Thread adderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("The feast.jpg");
            uploader.onNewPhotoAdded("Children.jpg");
            uploader.onNewPhotoAdded("Cars.jpg");
            uploader.onNewPhotoAdded("Selfie.jpg");
        });

        Thread uploadThread = new Thread(uploader ::startAutoUpload);

        adderThread.start();
        uploadThread.start();
    }
}

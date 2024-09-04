package ru.kraiush.threads.BJS2_18347;

public class AppGooglePhotoSync {

    public static void main(String[] args) {

        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(new UploadingPhoto(loader));
        Thread viewer = new Thread(new ViewingPhotos(loader));
        uploader.start();
        viewer.start();
    }

}

package ru.kraiush.BJS2_37206;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        String photoPath1 = "/photos/march/20240311_524.jpeg";
        String photoPath2 = "/photos/february/20240215_10224.jpeg";
        String photoPath3 = "/photos/march/20240321_4004.jpeg";
        String photoPath4 = "/photos/june/20240619_800.jpeg";
        String photoPath5 = "/photos/july/20240707_140.jpeg";

        Thread uploadPhoto = new Thread(() -> uploader.startAutoUpload());
        Thread addPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded(photoPath1);
            uploader.onNewPhotoAdded(photoPath2);
            uploader.onNewPhotoAdded(photoPath3);
            uploader.onNewPhotoAdded(photoPath4);
            uploader.onNewPhotoAdded(photoPath5);
        });

        uploadPhoto.start();
        addPhoto.start();
    }
}

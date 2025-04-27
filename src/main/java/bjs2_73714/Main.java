package bjs2_73714;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread automaticPhotoUpload = new Thread(uploader::startAutoUploader);
        Thread automaticAdditionOfPhotos = new Thread(() -> {
            uploader.onNewPhotoAdded("C:\\Users\\ИмяПользователя\\Pictures\\Vacation\\2023\\");
            uploader.onNewPhotoAdded("/Users/ИмяПользователя/Pictures/FamilyPhotos/");
            uploader.onNewPhotoAdded("/home/ИмяПользователя/Pictures/Nature/");
        });

        automaticPhotoUpload.start();
        automaticAdditionOfPhotos.start();
    }
}

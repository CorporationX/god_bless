package faang.school.godbless.googlePhoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        Thread secondThread = new Thread(googlePhotos::startAutoUpload); // просмотр
        Thread firstThread = new Thread(() -> googlePhotos.onNewPhotoAdded("Photo.img")); // загрузка
        secondThread.start();
        firstThread.start();
    }
}

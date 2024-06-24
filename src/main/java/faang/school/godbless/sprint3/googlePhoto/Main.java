package faang.school.godbless.sprint3.googlePhoto;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUpLoader googlePhotosAutoUploader = new GooglePhotosAutoUpLoader();

        Thread addingPhotoThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("photo3"));
        Thread gettingPhotoThread = new Thread(googlePhotosAutoUploader::startAutoUpload);

        gettingPhotoThread.start();
        addingPhotoThread.start();

    }
}

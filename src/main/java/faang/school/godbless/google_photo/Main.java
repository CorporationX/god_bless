package faang.school.godbless.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread upLoad = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String photo = "Photo_" + i + ".jpeg";
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
            }
        });
        upLoad.start();
        addPhoto.start();

    }
}

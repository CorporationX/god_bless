package faang.school.godbless.BJS2_24521;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread photoUploadThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("У самурая только путь");
        });

        Thread photoViewingThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        photoViewingThread.start();
        photoUploadThread.start();
    }
}

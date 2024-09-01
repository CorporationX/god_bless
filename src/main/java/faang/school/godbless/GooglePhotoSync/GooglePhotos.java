package faang.school.godbless.GooglePhotoSync;

public class GooglePhotos {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "Uploader Thread");

        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo2");
                Thread.sleep(4000);
                uploader.onNewPhotoAdded("photo3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Add photo interrupted.");
            }
        }, "Add Photo Thread");

        uploadThread.start();
        addPhotoThread.start();

        try {
            addPhotoThread.join();
            uploader.stop();
            uploadThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Join interrupted.");
        }
    }
}
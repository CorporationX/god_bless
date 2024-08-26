package faang.school.godbless.BJS2_26007;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread addPhotoThread = new Thread(() -> {
            uploader.onNewPhotoAdded("34r9gfkgofg.gpg");
            uploader.onNewPhotoAdded("dfdfdf.gpg");
            uploader.onNewPhotoAdded("efdf.gpg");
        });

        uploadThread.start();
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

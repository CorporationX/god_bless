package faang.school.godbless.googlePhoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            uploader.startAutoUpload();
        }, "UploadThread");

        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo#1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo#2.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo#3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("AddPhotoThread interrupted");
            }
        }, "AddPhotoThread");

        uploadThread.start();
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

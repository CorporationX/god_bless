package faang.school.godbless.BJS224437;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");

        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("madridFinal.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("CR7.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("withRonaldo.jpg");
            } catch (InterruptedException e) {
                System.out.println("Adding photos interrupted");
            }
        }, "AddPhotoThread");

        uploadThread.start();
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}

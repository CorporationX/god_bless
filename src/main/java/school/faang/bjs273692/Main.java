package school.faang.bjs273692;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                uploader.startAutoUpload();
            }
        });
        Thread addPhotoThread = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        });
        uploadThread.start();
        addPhotoThread.start();
    }
}

package school.faang.bjs248918;


public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread t1 = new Thread(uploader::startAutoUpload);

        Thread t2 = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
            uploader.onNewPhotoAdded("photo4.jpg");
        });

        t1.start();

        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Process is done !!!");
    }
}

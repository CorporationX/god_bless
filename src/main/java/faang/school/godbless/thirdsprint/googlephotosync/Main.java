package faang.school.godbless.thirdsprint.googlephotosync;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
                for (int i = 1; i < 10; i++) {
                    try {
                        Thread.sleep(300);
                        uploader.onNewPhotoAdded("/home/photos/photo" + i + ".jpg");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            addPhotosThread.join();
            uploadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
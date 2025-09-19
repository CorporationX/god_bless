package school.faang.bjs2_92485;

public class Main {
    private  static final int TIME_MILLIS = 2000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "UploadThread");

        Thread addPhotoThread = new Thread(() -> {
            String[] photos = {"photo1,jpg", "photo2.jpg", "photo3.jpg"};
            for (String photo : photos) {
                uploader.onNewPhotoAdded(photo);
                try {
                    Thread.sleep(TIME_MILLIS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "AddPhotoThread");

        uploadThread.start();
        addPhotoThread.start();

        try {
            addPhotoThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        uploadThread.interrupt();
        System.out.println("Все фотографии обработаны");
    }
}

package school.faang.task_48852;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread addPhotoThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
            }
        });
        addPhotoThread.start();

        try {
            addPhotoThread.join();
            uploadThread.join();
        } catch (InterruptedException e) {
            System.out.println("Произошла ошибка");
        }
    }
}

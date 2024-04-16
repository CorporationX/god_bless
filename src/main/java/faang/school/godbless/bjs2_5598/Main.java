package faang.school.godbless.bjs2_5598;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread uploadPhotosThread = new Thread(googlePhoto::startAutoUpload);
        Thread addNewPathToPhotoThread1 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/my_photo/foto1.jpg"));
        Thread addNewPathToPhotoThread2 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/my_photo/foto2.jpg"));
        Thread addNewPathToPhotoThread3 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/my_photo/foto3.jpg"));
        Thread addNewPathToPhotoThread4 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/my_photo/foto4.jpg"));
        Thread addNewPathToPhotoThread5 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/my_photo/foto5.jpg"));

        uploadPhotosThread.start();
        addNewPathToPhotoThread1.start();
        addNewPathToPhotoThread2.start();
        addNewPathToPhotoThread3.start();
        addNewPathToPhotoThread4.start();
        addNewPathToPhotoThread5.start();

        try {
            addNewPathToPhotoThread1.join();
            addNewPathToPhotoThread2.join();
            addNewPathToPhotoThread3.join();
            addNewPathToPhotoThread4.join();
            addNewPathToPhotoThread5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        uploadPhotosThread.interrupt();
    }
}

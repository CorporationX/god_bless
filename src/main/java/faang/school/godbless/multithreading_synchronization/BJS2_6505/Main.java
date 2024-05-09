package faang.school.godbless.multithreading_synchronization.BJS2_6505;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread uploadPhotosThread = new Thread(googlePhoto::startAutoUpload);
        Thread addNewPhotoThread1 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/folder/photo1.jpg"));
        Thread addNewPhotoThread2 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/folder/photo2.jpg"));
        Thread addNewPhotoThread3 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/folder/photo3.jpg"));
        Thread addNewPhotoThread4 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/folder/photo4.jpg"));
        Thread addNewPhotoThread5 = new Thread(() -> googlePhoto.onNewPhotoAdded("/photo/folder/photo5.jpg"));

        uploadPhotosThread.start();
        addNewPhotoThread1.start();
        addNewPhotoThread2.start();
        addNewPhotoThread3.start();
        addNewPhotoThread4.start();
        addNewPhotoThread5.start();

        try {
            addNewPhotoThread1.join();
            addNewPhotoThread2.join();
            addNewPhotoThread3.join();
            addNewPhotoThread4.join();
            addNewPhotoThread5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        uploadPhotosThread.interrupt();
    }
}

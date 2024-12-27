package school.faang.sprint3.task_bjs249004;

public class Main {

    public static final int PHOTO_COUNT = 100;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread photoAdderThread1 = new Thread(() -> addPhotos(uploader), "PhotoAdder-1");
        photoAdderThread1.start();

        Thread photoAdderThread2 = new Thread(() -> addPhotos(uploader), "PhotoAdder-2");
        photoAdderThread2.start();

        Thread photoAdderThread3 = new Thread(() -> addPhotos(uploader), "PhotoAdder-3");
        photoAdderThread3.start();

        try {
            photoAdderThread1.join();
            photoAdderThread2.join();
            photoAdderThread3.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Все потоки завершили работу");
    }

    private static void addPhotos(GooglePhotosAutoUploader uploader) {
        int photoCount = 0;
        while (photoCount < PHOTO_COUNT) {
            try {
                String photoPath = "E:\\Foto\\photo" + (int) (Math.random() * 100) + ".jpg";
                uploader.onNewPhotoAdded(photoPath);
                photoCount++;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " прерван");
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу");
    }

}
